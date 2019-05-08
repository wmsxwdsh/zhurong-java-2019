/**   
 * @Title: FileUtil.java
 * @Package: com.zhurong.utils.general
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.general;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import org.apache.commons.io.FileUtils;

/**
 * @description: File工具类
 * @author LZG
 * @date 2018/8/27
 */
public class FileUtil {

    /**
     * @Description: 获得文件的扩展名(扩展名不带".")
     * @param fileName
     * @return java.lang.String
     * @author LZG
     * @date 2018/8/27
     */
    public static String extName(String fileName) {
        if (fileName == null)
            return null;
        int index = fileName.lastIndexOf(".");
        if (index == -1)
            return null;
        String ext = fileName.substring(index + 1);
        return ext;
    }

    /**
     * @Description: 获取文件大小，返回KB，没有文件时返回0
     * @param filePath 文件路径
     * @return java.lang.String
     * @author LZG
     * @date 2018/9/20
     */
    public static String getFileSize(String filePath) {
        File file = new File(filePath);
        Double fileDoubleV = Double.valueOf(file.length());

        Double resultDouble = fileDoubleV / 1000.00;
        //不保留小数，五舍五入
        BigDecimal resultBigDecimal = new BigDecimal(resultDouble).setScale(0, BigDecimal.ROUND_HALF_UP);

        return resultBigDecimal.toString();
    }

    /**-------------------创建文件start--------------------------*/

    /**
     * @Description: 创建所给文件或目录的父目录
     * @param file
     * @return File
     * @author LZG
     * @date 2018/8/27
     */
    public static File mkParentDirs(File file) {
        final File parentFile = file.getParentFile();
        if (null != parentFile && false == parentFile.exists()) {
            parentFile.mkdirs();
        }
        return parentFile;
    }

    /**
     * @Description: 创建文件及其父目录。
     *      --如果这个文件存在，直接返回这个文件。
     *      --此方法不对File对象类型做判断，如果File不存在，无法判断其类型
     * @param file
     * @return File
     * @author LZG
     * @date 2018/8/27
     */
    public static File touch(File file) {
        if (null == file) {
            return null;
        }
        if (false == file.exists()) {
            mkParentDirs(file);
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return file;
    }
    /**-------------------创建文件end--------------------------*/

    /**
     * @Description: 删除文件
     * @param filePathAndName 文件路径及名称，例如：d://image//1.jpg
     * @return void
     * @author LZG
     * @date 2018/9/20
     */
    public static void delFile(String filePathAndName) {
        
        try {
            String filePath = filePathAndName;
            filePath = filePath.toString();
            File myDelFile = new File(filePath);

            if(!myDelFile.exists())
                throw new RuntimeException("要删除的文件不存在！");

            myDelFile.delete();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @Description: 删除文件夹
     * @param folderPathAndName
     * @return void
     * @author LZG
     * @date 2019/5/8
     */
    public static void delFolder(String folderPathAndName) {
        File folder = new File(folderPathAndName);
        if(folder.exists()) {
            try {
                FileUtils.deleteDirectory(folder);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}