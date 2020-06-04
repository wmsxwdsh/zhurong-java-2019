/**
 * @Title: MyTest.java
 * @Package: com.yuzhong.myspringboot.test
 * @author LZG, liuzhongguo@cdvcloud.com
 * Copyright (c) 2020 https://www.yunshicloud.com
 */
package com.yuzhong.myspringboot.controller.test;


import java.lang.reflect.Method;

/**
 * @author LZG
 * @description:
 * @date 2020年03月10日
 */
public class MyTest {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Client.class;
        Method method = clazz.getDeclaredMethod("main", String[].class);

        method.invoke(new Client(), new Object[]{null});
        method.invoke(null, new Object[]{null});
    }

}