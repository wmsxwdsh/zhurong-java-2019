/**   
 * @Title: RedisConfigureUtil.java
 * @Package: com.zhurong.utils.properties
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @description: Redis配置工具类
 *      --本质上是对com.onezg.baolongtool.core.util.PropertiesUtil的合理运用和扩展
 * @author LZG
 * @date 2018/8/27
 */
public class RedisConfigureUtil {

    // tokenId key
    private static String merchUserSessionTokenIdKey;
    // tokenId expire time
    private static String merchUserSessionTokenIdExpire;

    // validateCode key
    private static String merchUserSessionValidateCodeKey;
    // validateCode expire time
    private static String merchUserSessionValidateCodeExpire;

    static {

        Properties properties = new Properties();
        InputStream in = PropertiesUtil.class.getResourceAsStream("/config/token.properties");

        try {
            properties.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        merchUserSessionTokenIdKey = properties.getProperty("merchUser_SESSION_TOKENID_KEY");
        merchUserSessionTokenIdExpire = properties.getProperty("merchUser_SESSION_TOKENID_EXPIRE");
        merchUserSessionValidateCodeKey = properties.getProperty("merchUser_SESSION_VALIDATECODE_KEY");
        merchUserSessionValidateCodeExpire = properties.getProperty("merchUser_SESSION_VALIDATECODE_EXPIRE");
    }

    /* the merchUserSessionTokenIdKey */
    public static String getmerchUserSessionTokenIdKey() {
        return merchUserSessionTokenIdKey;
    }

    /* the merchUserSessionTokenIdExpire */
    public static String getmerchUserSessionTokenIdExpire() {
        return merchUserSessionTokenIdExpire;
    }

    /* the merchUserSessionValidateCodeKey */
    public static String getmerchUserSessionValidateCodeKey() {
        return merchUserSessionValidateCodeKey;
    }

    /* the merchUserSessionValidateCodeExpire */
    public static String getmerchUserSessionValidateCodeExpire() {
        return merchUserSessionValidateCodeExpire;
    }

    /* the merchUserSessionTokenIdKey to set */
    public static void setmerchUserSessionTokenIdKey(String merchUserSessionTokenIdKey) {
        RedisConfigureUtil.merchUserSessionTokenIdKey = merchUserSessionTokenIdKey;
    }

    /* the merchUserSessionTokenIdExpire to set */
    public static void setmerchUserSessionTokenIdExpire(String merchUserSessionTokenIdExpire) {
        RedisConfigureUtil.merchUserSessionTokenIdExpire = merchUserSessionTokenIdExpire;
    }

    /* the merchUserSessionValidateCodeKey to set */
    public static void setmerchUserSessionValidateCodeKey(String merchUserSessionValidateCodeKey) {
        RedisConfigureUtil.merchUserSessionValidateCodeKey = merchUserSessionValidateCodeKey;
    }

    /* the merchUserSessionValidateCodeExpire to set */
    public static void setmerchUserSessionValidateCodeExpire(String merchUserSessionValidateCodeExpire) {
        RedisConfigureUtil.merchUserSessionValidateCodeExpire = merchUserSessionValidateCodeExpire;
    }

}