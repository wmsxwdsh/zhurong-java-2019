/**   
 * @Title: IPAddressUtil.java
 * @Package: com.zhurong.utils.general
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.general;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.servlet.http.HttpServletRequest;

/**
 * @description: IP工具类
 * @author LZG
 * @date 2018/8/24
 */
public class IPAddressUtil {

    /**
     * @Description: 从request(请求)的头信息里获取客户端IP地址
     * @param request
     * @return java.lang.String
     * @author LZG
     * @date 2018/8/24
     */
    public static String getClientIPAddress(HttpServletRequest request) {

        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        /*
         * 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割 "***.***.***.***".length() = 15
         */
        if (ip != null && ip.length() > 15) {
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }
        return ip;
    }

    /**
     * @Description: 获取本机IP地址
     * @return java.lang.String
     * @author LZG
     * @date 2018/8/24
     */
    public static String getLocalIPAddress() {
        InetAddress inet = null;
        try {
            inet = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return inet.getHostAddress();
    }

    /**
     * @Description: test
     * @param args
     * @return void
     * @author LZG
     * @date 2018/8/24
     */
    public static void main(String[] args) {
        System.out.println(IPAddressUtil.getLocalIPAddress());
    }

}