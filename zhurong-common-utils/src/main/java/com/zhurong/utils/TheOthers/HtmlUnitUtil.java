package com.zhurong.utils.TheOthers;

import com.zhurong.utils.common.StringUtil;
import com.zhurong.utils.common.HttpClientUtil;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlImage;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import org.apache.commons.codec.binary.Base64OutputStream;

/**
 * HtmlUnit：爬虫工具&页面内容填充工具
 * <a href="https://blog.csdn.net/wxl901018/article/details/44133873">...</a>
 * 2018/9/26
 */
public class HtmlUnitUtil {

    /**
     * 根据 URL 和验证码 ElementId 获取图片的 Base64 编码
     * @param url 完整的 url地址（支付https）
     * @param vCodeElementId 验证码 ElementId（查看源码）
     */
    public static String getVCodeBase64Str(String url, String vCodeElementId) {

        if (StringUtil.isEmpty(url)) {
            throw new RuntimeException("url can't be empty");
        }

        //温馨提示
        System.out.println("此过程速度略慢，请耐心等待……");

        //设置浏览器版本为chrome
        WebClient webClient = new WebClient(BrowserVersion.CHROME);

        try {
            HtmlPage page = webClient.getPage(url);
            HtmlImage vCodeImg = (HtmlImage) page.getElementById(vCodeElementId);

            ImageReader imageReader = vCodeImg.getImageReader();

            //保存图片,方便人工和OCR服务识别的结果对比
            File file = new File("D:\\method.png");
            vCodeImg.saveAs(file);

            BufferedImage bufferedImage = imageReader.read(0);
            String formatName = imageReader.getFormatName();
            ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
            Base64OutputStream base64Output = new Base64OutputStream(byteOutput);
            ImageIO.write(bufferedImage, formatName, base64Output);
            String base64 = new String(byteOutput.toByteArray());

            return base64;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    //getVCodeBase64Str()测试
    private void test1() {
        //土耳其电子签证申请系统（https://www.evisa.gov.tr/zh/）,需要FQ（你懂的）
        String url = "https://www.evisa.gov.tr/zh/apply";
        //验证码的ElementId（查看页面源码）
        String vCodeElementId = "captcha_image";

        String base64Str = getVCodeBase64Str(url, vCodeElementId);
        //System.out.println(base64Str);

        //调用OCR识别（这类付费的服务很多）
        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("codetype", "1006");
        paramsMap.put("file_base64", base64Str);

        String ocrResult = HttpClientUtil.doPost(
            "https://xxx/code_recognition", paramsMap);
        System.out.println(ocrResult);
    }

    // HtmlUnit学习及测试
    private void test2() {
        WebClient webClient = new WebClient();

        try {
            //获取第一页, url为土耳其电子签证申请系统(https://www.evisa.gov.tr/zh/)
            HtmlPage page1 = webClient.getPage("https://www.evisa.gov.tr/zh/apply");

            //获取需要处理的表单，并在里面找到1、提交按钮 2、表单域
            //页面form name（查看源码）
            HtmlForm form1 = page1.getFormByName("form1");

            //提交按钮name（查看源码）
            HtmlSubmitInput button = (HtmlSubmitInput) form1.getInputsByName("ctl00$body$btnsubmit");

            //获取修改域并修改其值
            HtmlTextInput countryField = form1.getInputByName("ctl00$body$uyruklist_input");
            countryField.setValueAttribute("中国");

            HtmlTextInput countryCodeField = form1.getInputByName("ctl00$body$uyruklist");
            countryCodeField.setValueAttribute("CHN");

            HtmlTextInput travelDocumentField = form1.getInputByName("ctl00$body$belgelist");
            //UMP代表普通护照
            travelDocumentField.setValueAttribute("UMP");

            HtmlTextInput validateCodeField = form1.getInputByName("ctl00$body$recaptcha_response_field");
            //调用OCR识别服务获取结果
            travelDocumentField.setValueAttribute("xxxx");

            //通过点击按钮提交表单并获取返回页面
            HtmlPage page2 = button.click();

            webClient.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 测试
    public static void main(String[] args)  {
        HtmlUnitUtil htmlUnitUtil = new HtmlUnitUtil();

//        htmlUnitUtil.test1();
//        htmlUnitUtil.test2();
    }

}