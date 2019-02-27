/**
 * @Title: TestWatermarkUtil.java
 * @Package: com.zhurong.utils.general
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.general;

import java.awt.Color;
import org.junit.Test;

/**
 * @description: WatermarkUtil测试类
 *      --随便找两张图片测试就可以了。效果见本目录1.jpg
 * @author LZG
 * @date 2018/9/20
 */
public class TestWatermarkUtil {

    //------------原生方法测试--------start
    @Test
    public void testPressText() {
        WatermarkUtil.pressText("www.helloworld.com", "E:\\image\\1.jpg", "", 1, Color.RED, 25, 100, 200);
    }

    @Test
    public void testPressImage() {
        WatermarkUtil.pressImage("E:\\image\\superlogo.png", "E:\\image\\1.jpg", 300, 400);
    }
    //------------原生方法测试--------end


    //------------封装方法测试--------start
    @Test
    public void testSetTextWatermark() {
        WatermarkUtil.setTextWatermark("E:\\image\\1.jpg", "www.helloworld.com");
    }

    @Test
    public void testSetImageWatermark() {
        WatermarkUtil.setImageWatermark("E:\\image\\superlogo.png", "E:\\image\\1.jpg");
    }
    //------------封装方法测试--------end

}