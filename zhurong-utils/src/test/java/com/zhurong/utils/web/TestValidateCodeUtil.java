/**   
 * @Title: TestValidateCodeUtil.java
 * @Package: com.zhurong.utils.web
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.web;

import java.awt.image.BufferedImage;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: ValidateCodeUtil测试类(附使用方法)
 * @author LZG
 * @date 2018/8/27
 */
public class TestValidateCodeUtil {

    /**
     * @Description: 把验证码图片字符串(base64转码)写出到文件
     * @param args
     * @return void
     * @author LZG
     * @date 2018/8/27
     */
    @Test
    public void testWrite(String[] args) {
        ValidateCodeUtil vCodeUtil = new ValidateCodeUtil(200, 60, 4, 10);
        String vCode = vCodeUtil.getCode();
        System.out.println("生成的验证是：" + vCode);
        BufferedImage buffImg = vCodeUtil.getBuffImg();
        String encodeBase64ImgCode = vCodeUtil.encodeBase64ImgCode(buffImg);
        String imgFilePath = "D:\\hello.png";
        boolean result = vCodeUtil.generateImage(encodeBase64ImgCode, imgFilePath);
        if(result) {
            System.out.println("成功,可到" + imgFilePath + "查看文件");
        } else {
            System.out.println("失败");
        }

    }


    /**
     * @Description: 生成验证码服务接口
     *      1、分布式环境验证码验证不能用session,需要将验证码放到Redis里
     *      2、vCodeToken(验证码令牌)和验证码字符串(base64转码的串)都要返回给用户。
     *      3、验证码字符串在前端页面html或jsp里，把("data:image/PNG;base64," + base64转码的串)放到src里就可展示。
     * 	        ---src放的字符串格式为：data:image/PNG;base64," + base64转码的串
     *          ---可后台处理加上前缀给前端(推荐),也可以让前端自己加前缀拼串。
     *      4、注册或登录匹配验证码时,不管是否匹配,服务端redis里的key都要删除掉。
     *          ---只支持一次验证
     *          ---不匹配时返回给客户端,客户端需要重新生成验证码。
     *      5、vCodeToken验证码令牌,是为了验证对应问题。
     *      6、完整代码逻辑可参考聚合支付fitpay-merch-center项目(MerchUserController.java)
     * @param callback
     * @return java.lang.Object
     * @author LZG
     * @date 2018/8/27
     */
    @RequestMapping(value = "/getValidateCode")
    @ResponseBody
    public Object getValidateCode(String callback) {

		/*
		ResponseVO responseVO = new ResponseVO();

		if(StringUtils.isBlank(callback)) {
			responseVO.setRespCode("400");
			responseVO.setRespMsg("获取验证码仅支持JSONP的形式");
			return responseVO;
		}

		ValidateCodeUtil vCode = new ValidateCodeUtil(93, 30, 4, 10);
		String validateCode =  vCode.getCode(); //服务器生成的验证码
		String imgStr = "";

		try {
			imgStr = vCode.encodeBase64ImgCode(vCode.getBuffImg());
		} catch(Exception e) {
			responseVO.setRespCode("500");
			responseVO.setRespMsg("服务端错误,请稍后重试!");
			return responseVO;
		}

		//生成tokenId,将tokenId写入缓存中
		String vCodeToken = UUID.randomUUID().toString();
		merchUserService.writeValidateCodeToRedis(vCodeToken, validateCode);

		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("vCodeToken", vCodeToken);
		resultMap.put("imgStr", imgStr);

		String strOfresultMap = JsonUtil.objectToJson(resultMap);
		responseVO.setRespCode("200");
		responseVO.setRespMsg("成功");
		responseVO.setRespData(strOfresultMap);

		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(responseVO);
		mappingJacksonValue.setJsonpFunction(callback);
		return mappingJacksonValue;
		*/
        return null;
    }

}