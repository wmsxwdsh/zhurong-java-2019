/**
 * @Title: MathUtil.java
 * @Package: com.zhurong.utils.general
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.math;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;

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
            return new BigDecimal("0").setScale(0, BigDecimal.ROUND_HALF_UP);

        double result = (double) number1 / number2;

        if (result == 0.00)
            return new BigDecimal("0").setScale(0, BigDecimal.ROUND_HALF_UP);

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
            return new BigDecimal("0").setScale(0, BigDecimal.ROUND_HALF_UP);

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
    public static int plus(BigDecimal... args) {

        BigDecimal result = new BigDecimal("0");
        for (int i = 0; i < args.length; i++) {
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
     * @Description: 两个数相除的商, 保留两位小数
     * @param num1 被除数
     * @param num2 除数
     * @return java.lang.String
     * @author LZG
     * @date 2018/11/9
     */
    public static String divide(String num1, String num2) {
        if (0 == Integer.valueOf(num2))
            throw new RuntimeException("除数不能为0！");
        return divide(num1, num2, 2);
    }

    /**
     * @Description: 两个除数的商, 保留若干位小数
     * @param num1 被除数
     * @param num2 除数
     * @param scale 商的小数位数
     * @return java.lang.String
     * @author LZG
     * @date 2018/11/9
     */
    public static String divide(String num1, String num2, int scale) {
        if (0 == Integer.valueOf(num2))
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

    /**
     * @Description: 生成min到max间的随机整数（包含min和max）
     * @param min
     * @param max
     * @return int
     * @author LZG
     * @date 2019/3/12
     */
    public static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        int s = random.nextInt(max) % (max - min + 1) + min;
        return s;
    }

    /**
     * @Description: 小数转百分比（小数后4位）
     *          0.0005 转换为 0.05%
     *          0.005  转换为 0.50%
     *          0.05   转换为 5.00%
     *          0.5    转换为 50.00%
     *          5      转换为 500.00%
     *                  （12366）
     * @param d :
     * @return : null
     * @author LZG
     * @date 2020/06/19
     */
    public static String smallBigDecimal4ToPercent(BigDecimal d) {
        DecimalFormat df = new DecimalFormat("0.00%");
        String percent = df.format(d);
        return percent;
    }

    /**
     * @Description: 比较大小，num1 >= num2
     * @param num1 :
     * @param num2 :
     * @return : boolean
     * @author LZG
     * @date 2020/7/7
     */
    public static boolean isEqualAndGreater(BigDecimal num1, BigDecimal num2) {
        if (num1.compareTo(num2) == 1 || num1.compareTo(num2) == 0) {
            return true;
        }
        return false;
    }

    /**
     * @Description: 比较大小，num1 <= num2
     * @param num1 :
     * @param num2 :
     * @return : boolean
     * @author LZG
     * @date 2020/7/7
     */
    public static boolean isEqualAndLesser(BigDecimal num1, BigDecimal num2) {
        if (num1.compareTo(num2) == -1 || num1.compareTo(num2) == 0) {
            return true;
        }
        return false;
    }

    /**
     * @Description: 比较大小。等于。
     * @param num1 :
     * @param num2 :
     * @return : boolean
     * @author LZG
     * @date 2020/7/7
     */
    public static boolean isEqual(BigDecimal num1, BigDecimal num2) {
        if (num1.compareTo(num2) == 0) {
            return true;
        }
        return false;
    }

    /**
     * @Description: 判断BigDecimal是否为空或null
     * @param num :
     * @return : boolean
     * @author LZG
     * @date 2020/7/7
     */
    public static boolean isNullOrZero(BigDecimal num) {
        if(null == num || num.equals(BigDecimal.ZERO)) {
            return true;
        }
        return false;
    }

}