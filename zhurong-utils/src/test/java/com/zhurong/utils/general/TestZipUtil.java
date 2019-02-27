/**   
 * @Title: TestZipUtil.java
 * @Package: com.zhurong.utils.general
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.general;

import org.junit.Test;

/**
 * @description: ZipUtil测试类
 * @author LZG
 * @date 2018/9/21
 */
public class TestZipUtil {

    // 把一个文件压缩成zip
    @Test
    public void test1() {
        String srcPath = "E:\\superlogo.png";
        String zipPath = "E:\\hello\\"; //没有hello文件夹会自己创建
        String zipName = "图片2.zip";

        ZipUtil.zip(srcPath, zipPath, zipName);
    }

    // 把一个文件夹压缩成zip
    @Test
    public void test2() {
        String srcPath = "E:\\image";
        String zipPath = "E:\\world";
        String zipName = "大杂汇.zip";

        ZipUtil.zip(srcPath, zipPath, zipName);
    }

    // 解压zip
    @Test
    public void test3() {
        String zipFilePath = "E:\\world\\大杂汇.zip";
        String unzipFilePath = "E:\\unzip操作";
        boolean includeZipFileName = false;

        try {
            ZipUtil.unzip(zipFilePath, unzipFilePath, includeZipFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}