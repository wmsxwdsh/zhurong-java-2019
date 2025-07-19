/**
 * @Title: TestMathUtil.java
 * @Package: com.zhurong.utils.general
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.math;

import java.math.BigDecimal;
import org.junit.Test;

/**
 * @description: MathUtil测试类
 * @author LZG
 * @date 2018/8/27
 */
public class Md5SaltTestMathUtil {

    @Test
    public void test() {

        System.out.println(MathUtil.divide(10, 0));
        System.out.println(MathUtil.divide(9, 8));
        System.out.println(MathUtil.divide(0, 8));
        System.out.println(MathUtil.divide(1, 8));

        BigDecimal number1 = new BigDecimal("10");
        BigDecimal number2 = new BigDecimal("0");
        BigDecimal number3 = new BigDecimal("8");

        System.out.println(MathUtil.divide(number1, number2));
        System.out.println(MathUtil.divide(number1, number3));

        System.out.println(MathUtil.plus(number1, number2, new BigDecimal("0.33")));
        System.out.println(MathUtil.plus(number1, number2, new BigDecimal("0.52")));
    }

    @Test
    public void test2() {
        for (int i = 0; i < 20; i++) {
            int result = MathUtil.generateRandomNumber(5, 15);
            System.out.println(result);
        }
    }

    @Test
    public void test3() {
        BigDecimal b1 = new BigDecimal(0.0005);
        BigDecimal b2 = new BigDecimal(0.005);
        BigDecimal b3 = new BigDecimal(0.05);
        BigDecimal b4 = new BigDecimal(0.5);
        BigDecimal b5 = new BigDecimal(5);

        System.out.println(MathUtil.smallBigDecimal4ToPercent(b1));
        System.out.println(MathUtil.smallBigDecimal4ToPercent(b2));
        System.out.println(MathUtil.smallBigDecimal4ToPercent(b3));
        System.out.println(MathUtil.smallBigDecimal4ToPercent(b4));
        System.out.println(MathUtil.smallBigDecimal4ToPercent(b5));
    }

    @Test
    public void test4() {
        BigDecimal b1 = new BigDecimal(1.05);
        BigDecimal b2 = new BigDecimal(1.050);
        System.out.println(MathUtil.isEqual(b1, b2)); //true

        BigDecimal b3 = new BigDecimal(5.89);
        BigDecimal b4 = new BigDecimal(2.056);
        System.out.println(MathUtil.isEqualAndGreater(b3, b4)); //true
        System.out.println(MathUtil.isEqualAndGreater(b4, b3)); //false

        BigDecimal b5 = new BigDecimal(4.11);
        BigDecimal b6 = new BigDecimal(10.456);
        System.out.println(MathUtil.isEqualAndLesser(b5, b6)); //true
        System.out.println(MathUtil.isEqualAndLesser(b6, b5)); //false
    }

    @Test
    public void test5() {
        //NumberFormatException
//        BigDecimal b1 = new BigDecimal("");

        BigDecimal b2 = null;
        BigDecimal b3 = new BigDecimal(0);

        System.out.println(MathUtil.isNullOrZero(b2)); //true
        System.out.println(MathUtil.isNullOrZero(b3)); //true
    }

    @Test
    public void test6() {
        BigDecimal b1 = new BigDecimal("9.0300");
        BigDecimal b2 = new BigDecimal("9.00");
        System.out.println(MathUtil.stripSuffix(b1));
        System.out.println(MathUtil.stripSuffix(b2));
    }


}