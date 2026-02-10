package com.yuzhong.myspringboot.v1.test;


import java.lang.reflect.Method;

public class MyTest {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Client.class;
        Method method = clazz.getDeclaredMethod("main", String[].class);

        method.invoke(new Client(), new Object[]{null});
        method.invoke(null, new Object[]{null});
    }

}