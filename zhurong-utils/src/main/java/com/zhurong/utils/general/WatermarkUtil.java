/**
 * @Title: WatermarkUtil.java
 * @Package: com.zhurong.utils.general
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.general;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;

/**
 * @description: 图片水印处理工具类
 * @author LZG
 * @date 2018/9/20
 */
public class WatermarkUtil {

    /**
     * @Description: 图片左上角添加文字水印
     *      --第2次封装方法，不能满足需求请使用pressText()
     * @param imagePath 目标图片路径
     * @param text 要添加水印的文字
     * @return void
     * @author LZG
     * @date 2018/9/20
     */
    public static void setTextWatermark(String imagePath, String text) {
        pressText(text, imagePath, "", 1, Color.RED, 20, 1, 1);
    }

    /**
     * @Description: 图片左上角添加图片水印
     *      --第2次封装，不能满足需求请使用pressImage()
     * @param watermarkImg
     * @return void
     * @author LZG
     * @date 2018/9/20
     */
    public static void setImageWatermark(String watermarkImg, String targetImg) {
        pressImage(watermarkImg, targetImg, 1, 1);
    }


    /**
     * @Description: 文字水印
     * @param pressText 文字
     * @param targetImg 目标图片路径
     * @param fontName 字体名
     * @param fontStyle 字体样式
     * @param color 字体颜色
     * @param fontSize 字体大小
     * @param x x轴偏移量
     * @param y y轴偏移量
     *      注：x=1,y=1 图片最左上角
     *      x=width,y=height 图片最右下角
     * @return void
     * @author LZG
     * @date 2018/9/20
     */
    public final static void pressText(String pressText, String targetImg, String fontName, int fontStyle, Color color, int fontSize, int x, int y) {

        try {
            File file = new File(targetImg);
            Image src = ImageIO.read(file);

            int width = src.getWidth(null);
            int height = src.getHeight(null);
            System.out.println(width + ":" + height);

            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics g = image.createGraphics();
            g.drawImage(src, 0, 0, width, height, null);
            g.setColor(color);
            g.setFont(new Font(fontName, fontStyle, fontSize));
            g.drawString(pressText, x, y);
            g.dispose();

            FileOutputStream out = new FileOutputStream(targetImg);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(image);
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @Description: 添加图片水印
     * @param pressImg 水印图片路径
     * @param targetImg 目标图片路径
     * @param x X坐标
     * @param y Y坐标
     * @return void
     * @author LZG
     * @date 2018/9/20
     */
    public final static void pressImage(String pressImg, String targetImg, int x, int y) {

        try {
            //目标文件
            File file = new File(targetImg);
            Image src = ImageIO.read(file);

            int width = src.getWidth(null);
            int height = src.getHeight(null);
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics g = image.createGraphics();
            g.drawImage(src, 0, 0, width, height, null);

            //水印文件
            File watermarkFile = new File(pressImg);
            Image watermarkFileSrc = ImageIO.read(watermarkFile);
            int width1 = watermarkFileSrc.getWidth(null);
            int height1 = watermarkFileSrc.getHeight(null);
            g.drawImage(watermarkFileSrc, x, y, width1, height1, null);
            //水印文件结束
            g.dispose();

            FileOutputStream out = new FileOutputStream(targetImg);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(image);
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}