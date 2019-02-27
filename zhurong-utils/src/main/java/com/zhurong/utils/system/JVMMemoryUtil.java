/**   
 * @Title: JVMMemoryUtil.java
 * @Package: com.zhurong.utils.system
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.system;

/**
 * @description: JVM内存查询工具类
 * @author LZG
 * @date 2018/8/27
 */
public class JVMMemoryUtil {

    public static String getJVMMemoryInfo() {
        Runtime currRuntime = Runtime.getRuntime();
        int nFreeMemory = (int) (currRuntime.freeMemory() / 1024 / 1024);
        int nTotalMemory = (int) (currRuntime.totalMemory() / 1024 / 1024);
        return nFreeMemory + "M/" + nTotalMemory + "M(free/total)";
    }

    // test
    public static void main(String[] args) {
        System.out.println(JVMMemoryUtil.getJVMMemoryInfo());
    }

}