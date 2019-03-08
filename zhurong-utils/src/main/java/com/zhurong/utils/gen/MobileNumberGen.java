/**   
 * @Title: MobileNumberGen.java
 * @Package: com.zhurong.utils.gen
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.utils.gen;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @description: 手机号生成器
 * @author LZG
 * @date 2018/11/5
 */
public class MobileNumberGen {

    private static final int[] MOBILE_PREFIX = new int[]{133, 153, 177, 180,
        181, 189, 134, 135, 136, 137, 138, 139, 150, 151, 152, 157, 158, 159,
        178, 182, 183, 184, 187, 188, 130, 131, 132, 155, 156, 176, 185, 186,
        145, 147, 170};


    /**
     * @Description: 生成随机手机号码
     * @return java.lang.String
     * @author LZG
     * @date 2018/11/5
     */
    public static String generate() {
        return genMobilePre() + StringUtils
            .leftPad("" + RandomUtils.nextInt(0, 99999999 + 1), 8, "0");
    }

    /**
     * @Description: 生成假的手机号码（以19开头）
     * @return java.lang.String
     * @author LZG
     * @date 2018/11/5
     */
    public static String generateFake() {
        return "19" + StringUtils
            .leftPad("" + RandomUtils.nextInt(0, 999999999 + 1), 9, "0");
    }

    /**
     * @Description: 获取手机号的前缀
     * @return java.lang.String
     * @author LZG
     * @date 2018/11/5
     */
    private static String genMobilePre() {
        return "" + MOBILE_PREFIX[RandomUtils.nextInt(0, MOBILE_PREFIX.length)];
    }

}