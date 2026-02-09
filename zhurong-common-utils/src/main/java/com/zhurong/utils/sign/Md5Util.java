package com.zhurong.utils.sign;

import java.security.MessageDigest;

/**
 * 纯粹的 MD5 工具类
 * 2019/7/28
 */
public class Md5Util {

    /**
     * 字符串进行 md5 加密
     */
    public static String string2MD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = ((byte) charArray[i]);
        }
        byte[] md5Bytes = md5.digest(byteArray);

        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = md5Bytes[i] & 0xFF;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }

        return hexValue.toString();
    }

    //test
    public static void main(String[] args) {
        //md5码：7b9f9e57bc99618dd3368b35a1e7caed
        String pwd = "hdswj68$fxxt28";
        System.out.println(string2MD5(pwd));
    }

}