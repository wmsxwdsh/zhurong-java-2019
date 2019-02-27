/**
 * @Title: ValidateCodeUtil.java
 * @Package: com.zhurong.utils.web
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;

/**
 * @description: 验证码工具类
 *      参考：http://www.xwood.net/_site_domain_/_root/5870/5874/t_c267326.html
 * @author LZG
 * @date 2018/8/27
 */
public class ValidateCodeUtil {

    // 图片的宽度
    private int width = 150;
    // 图片的高度。
    private int height = 35;
    // 验证码字符个数
    private int codeCount = 4;
    // 验证码干扰线数
    private int lineCount = 20;
    // 验证码
    private String code = null;

    // 验证码图片Buffer
    private BufferedImage buffImg = null;

    Random random = new Random();

    public ValidateCodeUtil() {
        creatImage();
    }

    // 宽度、高度
    public ValidateCodeUtil(int width, int height) {
        this.width = width;
        this.height = height;
        creatImage();
    }

    // 宽度、高度、验证码字符个数
    public ValidateCodeUtil(int width, int height, int codeCount) {
        this.width = width;
        this.height = height;
        this.codeCount = codeCount;
        creatImage();
    }

    // 宽度、高度、验证码字符个数、验证码干扰线数
    public ValidateCodeUtil(int width, int height, int codeCount, int lineCount) {
        this.width = width;
        this.height = height;
        this.codeCount = codeCount;
        this.lineCount = lineCount;
        creatImage();
    }

    // 生成图片
    private void creatImage() {
        // 字体的宽度
        int fontWidth = width / codeCount;
        // 字体的高度
        int fontHeight = height - 5;
        int codeY = height - 8;

        // 图像buffer
        buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = buffImg.getGraphics();
        //Graphics2D g = buffImg.createGraphics();

        // 设置背景色
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);

        // 设置字体
        //Font font = getFont(fontHeight);
        Font font = new Font("Fixedsys", Font.BOLD, fontHeight);
        g.setFont(font);

        // 设置干扰线
        for (int i = 0; i < lineCount; i++) {
            int xs = random.nextInt(width);
            int ys = random.nextInt(height);
            int xe = xs + random.nextInt(width);
            int ye = ys + random.nextInt(height);
            g.setColor(getRandColor(1, 255));
            g.drawLine(xs, ys, xe, ye);
        }

        // 添加噪点
        float yawpRate = 0.01f;// 噪声率
        int area = (int) (yawpRate * width * height);
        for (int i = 0; i < area; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);

            buffImg.setRGB(x, y, random.nextInt(255));
        }

        String str1 = randomStr(codeCount);// 得到随机字符
        this.code = str1;
        for (int i = 0; i < codeCount; i++) {
            String strRand = str1.substring(i, i + 1);
            g.setColor(getRandColor(1, 255));
            // g.drawString(a,x,y);
            // a为要画出来的东西，x和y表示要画的东西最左侧字符的基线位于此图形上下文坐标系的 (x, y) 位置处
            g.drawString(strRand, i * fontWidth + 3, codeY);
        }

    }

    // 得到随机字符
    private String randomStr(int n) {
        String str1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        String str2 = "";
        int len = str1.length() - 1;
        double r;
        for (int i = 0; i < n; i++) {
            r = (Math.random()) * len;
            str2 = str2 + str1.charAt((int) r);
        }
        return str2;
    }

    // 得到随机颜色
    private Color getRandColor(int fc, int bc) {
        // 给定范围获得随机颜色
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    // 产生随机字体
    private Font getFont(int size) {
        Random random = new Random();
        Font font[] = new Font[5];
        font[0] = new Font("Ravie", Font.PLAIN, size);
        font[1] = new Font("Antique Olive Compact", Font.PLAIN, size);
        font[2] = new Font("Fixedsys", Font.PLAIN, size);
        font[3] = new Font("Wide Latin", Font.PLAIN, size);
        font[4] = new Font("Gill Sans Ultra Bold", Font.PLAIN, size);
        return font[random.nextInt(5)];
    }

    public void write(OutputStream sos) throws IOException {
        ImageIO.write(buffImg, "png", sos);
        sos.close();
    }

    public BufferedImage getBuffImg() {
        return buffImg;
    }

    public String getCode() {
        return code.toLowerCase();
    }

    // 图片生成的base64的验证码数据
    public String encodeBase64ImgCode(BufferedImage buffImg) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ImageIO.write(buffImg, "png", out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] b = out.toByteArray();
        String imgStr = Base64.encodeBase64String(b);
        return imgStr;
    }

    /**
     * @Description: 将base64转码后字符串转换成图片,写到相关目录
     * @param encodeBase64ImgStr base64转码后字符串
     * @param imgFilePath 文件路径(比如 D:\\hello.png)
     * @return boolean 是否成功
     * @author LZG
     * @date 2018/8/27
     */
    public boolean generateImage(String encodeBase64ImgStr, String imgFilePath) {
        // 图像数据为空
        if (encodeBase64ImgStr == null) {
            return false;
        }
        BASE64Decoder decoder = new BASE64Decoder();

        try {
            // Base64解码
            byte[] bytes = decoder.decodeBuffer(encodeBase64ImgStr);
            for (int i = 0; i < bytes.length; ++i) {
                // 调整异常数据
                if (bytes[i] < 0) {
                    bytes[i] += 256;
                }
            }
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(bytes);
            out.flush();
            out.close();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * @Description: 传统单机服务器方案
     *      生成验证码的时候放入session，验证验证码的时候从request里获取session在获取验证码比较即可。
     * @param req
     * @param response
     * @param session
     * @return void
     * @author LZG
     * @date 2018/8/27
     */
    public void testDanJi(HttpServletRequest req, HttpServletResponse response, HttpSession session)
        throws IOException {
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        ValidateCodeUtil vCode = new ValidateCodeUtil(100, 30, 5, 10);
        session.setAttribute("code", vCode.getCode());
        vCode.write(response.getOutputStream());
        // 前端页面img的src标签放这个方法对应的controller就可得到验证码图片。
    }


    // test生成指定长度随机字符串
    public static void main(String[] args) {
        ValidateCodeUtil vcUtil = new ValidateCodeUtil();
        String result = vcUtil.randomStr(10);
        System.out.println(result);
    }

}