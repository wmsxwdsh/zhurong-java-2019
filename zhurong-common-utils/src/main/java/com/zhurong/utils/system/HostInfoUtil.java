/**   
 * @Title: HostInfoUtil.java
 * @Package: com.zhurong.utils.system
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.system;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @description: 主机信息工具类
 * @author LZG
 * @date 2018/8/27
 */
public class HostInfoUtil {

    private static String HOST_NAME;
    private static String HOST_ADDRESS;

    static {

        try {
            InetAddress localhost = InetAddress.getLocalHost();

            HOST_NAME = localhost.getHostName();
            HOST_ADDRESS = localhost.getHostAddress();
        } catch (UnknownHostException e) {
            HOST_NAME = "localhost";
            HOST_ADDRESS = "127.0.0.1";
        }

    }

    /**
     * @Description: 取得当前主机的名称
     * @return java.lang.String
     * @author LZG
     * @date 2018/8/27
     */
    public static String getName() {
        return HOST_NAME;
    }

    /**
     * @Description: 取得当前主机的IP地址
     * @return java.lang.String
     * @author LZG
     * @date 2018/8/27
     */
    public static String getAddress() {
        return HOST_ADDRESS;
    }

    // test
    public static void main(String[] args) {

        System.out.println(HostInfoUtil.HOST_NAME);
        System.out.println(HostInfoUtil.HOST_ADDRESS);
    }

}