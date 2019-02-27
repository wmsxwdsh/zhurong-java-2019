/**   
 * @Title: MathUtil.java
 * @Package: com.zhurong.utils.general
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.general;

import java.math.BigDecimal;

/**
 * @description: 计算工具类
 *      本人于上海银联数据分析开发时所写，现收录。
 * @author LZG
 * @date 2018/8/27
 */
public class MathUtil {

    /**
     * @Description: int数相除。保留两位小数，四舍五入。
     * @param number1
     * @param number2
     * @return java.math.BigDecimal
     * @author LZG
     * @date 2018/8/27
     */
    public static BigDecimal divide(int number1, int number2) {
        if (number2 == 0)
            return new BigDecimal("0").setScale(0,BigDecimal.ROUND_HALF_UP);

        double result = (double) number1 / number2;

        if (result == 0.00)
            return new BigDecimal("0").setScale(0,BigDecimal.ROUND_HALF_UP);

        BigDecimal value = new BigDecimal(result).setScale(2, BigDecimal.ROUND_HALF_UP);
        return value;
    }

    /**
     * @Description: BigDecimal数相除。保留两位小数,四舍五入。
     * @param number1
     * @param number2
     * @return
     * @author LZG
     * @date 2018年07月10日
     */
    public static BigDecimal divide(BigDecimal number1, BigDecimal number2) {
        if (number2.equals(BigDecimal.ZERO))
            return new BigDecimal("0").setScale(0,BigDecimal.ROUND_HALF_UP);

        BigDecimal result = number1.divide(number2, 4, BigDecimal.ROUND_HALF_UP);
        return result;
    }

    /**
     * @Description: 加计算
     * @param args
     * @return int
     * @author LZG
     * @date 2018/8/27
     */
    public static int plus(BigDecimal ...args) {

        BigDecimal result = new BigDecimal("0");
        for(int i = 0; i < args.length; i++) {
            result = result.add(args[i]);
        }
        //四舍五入
        result = result.setScale(0, BigDecimal.ROUND_HALF_UP);
        return Integer.parseInt(result.toString());
    }

    /**
     * @Description: 两个数字相加
     * @param num1 第一个加数
     * @param num2 第二个加数
     * @return java.lang.String
     * @author LZG
     * @date 2018/11/9
     */
    public static String add(String num1, String num2) {
        BigDecimal dec1 = new BigDecimal(num1);
        BigDecimal dec2 = new BigDecimal(num2);
        return dec1.add(dec2).toString();
    }

    /**
     * @Description: 两个数字想减
     * @param num1 被减数
     * @param num2 减数
     * @return java.lang.String
     * @author LZG
     * @date 2018/11/9
     */
    public static String subtract(String num1, String num2) {
        BigDecimal dec1 = new BigDecimal(num1);
        BigDecimal dec2 = new BigDecimal(num2);
        return dec1.subtract(dec2).toString();
    }

    /**
     * 两个数相乘的积
     *
     * @param num1 被乘数
     * @param num2 乘数
     * @return 两个数相乘的积
     * @since 1.0
     */
    public static String multiply(String num1, String num2) {
        BigDecimal dec1 = new BigDecimal(num1);
        BigDecimal dec2 = new BigDecimal(num2);
        return dec1.multiply(dec2).toString();
    }

    /**
     * @Description: 两个数相除的商,保留两位小数
     * @param num1 被除数
     * @param num2 除数
     * @return java.lang.String
     * @author LZG
     * @date 2018/11/9
     */
    public static String divide(String num1, String num2) {
        if(0 == Integer.valueOf(num2))
            throw new RuntimeException("除数不能为0！");
        return divide(num1, num2, 2);
    }

    /**
     * @Description: 两个除数的商,保留若干位小数
     * @param num1 被除数
     * @param num2 除数
     * @param scale 商的小数位数
     * @return java.lang.String
     * @author LZG
     * @date 2018/11/9
     */
    public static String divide(String num1, String num2, int scale) {
        if(0 == Integer.valueOf(num2))
            throw new RuntimeException("除数不能为0！");

        BigDecimal dec1 = new BigDecimal(num1);
        BigDecimal dec2 = new BigDecimal(num2);
        return dec1.divide(dec2, scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * @Description: 求相反数
     * @param num 原始数值
     * @return java.lang.String
     * @author LZG
     * @date 2018/11/9
     */
    public static String negate(String num) {
        return new BigDecimal(num).negate().toString();
    }

}