/**
 * @Title: DeviceUtil.java
 * @Package: com.zhurong.utils.general
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.general;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: 设备工具类
 * @author LZG
 * @date 2018/11/12
 */
public class DeviceUtil {

    /**
     * @Description: 判断是否是移动设备
     * @param request
     * @return boolean
     * @author LZG
     * @date 2018/11/12
     */
    public static boolean isMobileDevice(HttpServletRequest request) {
        String userAgent = request.getHeader("user-agent").toLowerCase();

        //anroid手机
        if (userAgent.indexOf("android") != -1)
            return true;
        //苹果手机
        if (userAgent.indexOf("iphone") != -1 || userAgent.indexOf("ipad") != -1 || userAgent.indexOf("ipod") != -1)
            return true;
        //小米手机
        if (userAgent.indexOf("mi") != -1)
            return true;
        //联想手机
        if (userAgent.indexOf("lenovo") != -1)
            return true;
        return false;
    }

}