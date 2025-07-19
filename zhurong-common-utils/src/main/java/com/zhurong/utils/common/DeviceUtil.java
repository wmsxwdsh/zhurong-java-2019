package com.zhurong.utils.common;

import javax.servlet.http.HttpServletRequest;

/**
 * 移动设备工具类
 * @author LZG
 * @date 2018/11/12
 */
public class DeviceUtil {

    /**
     * 判断是否是移动设备
     * @date 2018/11/12
     */
    public static boolean isMobileDevice(HttpServletRequest request) {
        String userAgent = request.getHeader("user-agent").toLowerCase();

        //anroid手机
        if (userAgent.contains("android"))
            return true;
        //苹果手机
        if (userAgent.contains("iphone") || userAgent.contains("ipad") || userAgent.contains("ipod"))
            return true;
        //小米手机
        if (userAgent.contains("mi"))
            return true;
        //联想手机
        if (userAgent.contains("lenovo"))
            return true;
        return false;
    }

}