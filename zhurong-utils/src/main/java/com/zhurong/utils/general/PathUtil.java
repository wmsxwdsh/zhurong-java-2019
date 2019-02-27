/**
 * @Title: PathUtil.java
 * @Package: com.zhurong.utils.general
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.general;

import java.io.File;
import java.net.URL;

/**
 * @description: 路径辅助类
 * @author LZG
 * @date 2018/9/20
 */
public class PathUtil {

    /**
     * @Description: 获取项目根路径
     * @return java.lang.String
     * @author LZG
     * @date 2018/9/20
     */
    public static String getProjectPath() {
        //File.separator兼顾windows和linux的分割符
        return System.getProperty("user.dir") + File.separator;
    }

    /**
     * @Description: 获取classpath
     *      --resources、jsp、css等都在这个路径下
     * @return java.lang.String
     * @author LZG
     * @date 2018/9/20
     */
    public static String getClassResources() {
        String resource = String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""));
        String path = resource.replaceAll("file:/", "").replaceAll("%20", " ").trim();

        if (path.indexOf(":") != 1) {
            path = File.separator + path;
        }

        return path;
    }

    // 测试
    public static void main(String[] args) {
        System.out.println(getProjectPath());
        System.out.println(getClassResources());
    }

}