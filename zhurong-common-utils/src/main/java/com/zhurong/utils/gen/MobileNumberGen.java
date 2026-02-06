package com.zhurong.utils.gen;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 手机号生成器
 */
public class MobileNumberGen {

    private static final int[] MOBILE_PREFIX = new int[]{133, 153, 177, 180,
        181, 189, 134, 135, 136, 137, 138, 139, 150, 151, 152, 157, 158, 159,
        178, 182, 183, 184, 187, 188, 130, 131, 132, 155, 156, 176, 185, 186,
        145, 147, 170};


    /**
     * 生成随机手机号码
     * @return java.lang.String
     */
    public static String generate() {
        return genMobilePre() + StringUtils
            .leftPad("" + RandomUtils.nextInt(0, 99999999 + 1), 8, "0");
    }

    /**
     * 生成假的手机号码（以19开头）
     * @return java.lang.String
     */
    public static String generateFake() {
        return "19" + StringUtils
            .leftPad("" + RandomUtils.nextInt(0, 999999999 + 1), 9, "0");
    }

    /**
     * 获取手机号的前缀
     * @return java.lang.String
     */
    private static String genMobilePre() {
        return "" + MOBILE_PREFIX[RandomUtils.nextInt(0, MOBILE_PREFIX.length)];
    }


    public static void main(String[] args) {
        //生成真手机号码
        String result = MobileNumberGen.generate();
        System.out.println(result);

        //生成假的手机号码
        String result2 = MobileNumberGen.generateFake();
        System.out.println(result2);
    }
}