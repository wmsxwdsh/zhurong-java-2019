package com.zhurong.utils.common;

import java.io.File;

/**
 * 路径辅助类
 * @date 2018/9/20
 */
public class PathUtil {

    /**
     * 获取项目根路径
     * @date 2018/9/20
     */
    public static String getProjectPath() {
        // File.separator兼顾windows和linux的分割符
        return System.getProperty("user.dir") + File.separator;
    }

    /**
     * 获取classpath（resources、jsp、css等都在这个路径下）
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


    // 测试一下
    public static void main(String[] args) {
        System.out.println(getProjectPath());
        System.out.println(getClassResources());
    }

}