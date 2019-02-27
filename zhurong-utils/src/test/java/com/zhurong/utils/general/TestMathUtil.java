/**   
 * @Title: TestMathUtil.java
 * @Package: com.zhurong.utils.general
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.general;

import java.math.BigDecimal;
import org.junit.Test;

/**
 * @description: MathUtil测试类
 * @author LZG
 * @date 2018/8/27
 */
public class TestMathUtil {

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

}