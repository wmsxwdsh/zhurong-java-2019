/**
 * @Title: MaskUtil.java
 * @Package: com.zhurong.utils
 * @author LZG, liuzg@12366.com
 * Copyright (c) 2020 http://www.12366.com
 */
package com.zhurong.utils.content;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * @description: 脱敏工具
 * @author LZG
 * @date 2020年06月15日
 */
public class MaskUtil {

    /**
     * @Description: 身份证号脱敏
     * @param cardNum :
     * @return : java.lang.String
     * @author LZG
     * @date 2020/6/15
     */
    public static String iDCardDecryption(String cardNum) {
        if (StringUtils.isBlank(cardNum)) {
            return "";
        }
        return StringUtils.left(cardNum, 6).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(cardNum, 4), StringUtils.length(cardNum), "*"), "******"));
    }

    /**
     * @Description: 手机号脱敏
     * @param phone :
     * @return : java.lang.String
     * @author LZG
     * @date 2020/6/15
     */
    public static String phoneDesensitization(String phone) {
        if (StringUtils.isBlank(phone)) {
            return "";
        }
        return StringUtils.left(phone, 3).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(phone, 4), StringUtils.length(phone), "*"), "***"));
    }

    /**
     * @Description: 银行卡脱敏
     * @param cardNum :
     * @return : java.lang.String
     * @author LZG
     * @date 2020/6/15
     */
    public static String bankCard(String cardNum) {
        if (StringUtils.isBlank(cardNum)) {
            return "";
        }
        return StringUtils.left(cardNum, 6).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(cardNum, 4), StringUtils.length(cardNum), "*"), "******"));
    }

    /**
     * @Description: 字符串截取
     * @param url : 特定情况特定写。
     * @return : java.lang.String
     * @author LZG
     * @date 2020/6/15
     */
    public static String splitFileTypeName(String url) {
        String splitString = "?";
        String picName = "";
        //https://file-img.test.12366.com/02/vou/content/39306465ca5d45fabca80f64c993ae27.jpg?Expires=1590322176&OSSAccessKeyId=LTAI4G7pdx2MDYJR4C4teLsK&Signature=hhLH5hT%2FMLA9BnSpr0NpqcloG1I%3D
        if (url.indexOf(splitString) > 0) {
            //https://file-img.test.12366.com/02/vou/content/39306465ca5d45fabca80f64c993ae27.jpg
            url = url.substring(0, url.lastIndexOf("?"));
        }
        picName = url.substring(url.lastIndexOf("/") + 1);
        String[] types = picName.split("\\.");
        //39306465ca5d45fabca80f64c993ae27.jpg
        return types[types.length - 1];
    }

    /**
     * @Description: boolean 转 byte
     * @param bool :
     * @return : byte
     * @author LZG
     * @date 2020/6/15
     */
    public static byte convert(Boolean bool) {
        return (byte) (bool ? 1 : 0);
    }


    public static String[] chars = new String[]{"a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};


    //获得32位UUID
    public static String getUUid() {
        String uuid = UUID.randomUUID().toString();
        //去掉“-”符号
        return uuid.replaceAll("-", "");
    }

    //获取短UUID
    public static String getRandomNum() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = MaskUtil.getUUid();
        for (int i = 0; i < 6; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();
    }

}