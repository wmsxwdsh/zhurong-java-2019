/**   
 * @Title: TestDoWhile.java
 * @Package: com.zhurong.jdk.base
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 https://onezg.cnblogs.com
 */
package com.zhurong.jdk.base;

/**
 * @description: 
 * @author LZG
 * @date 2019/10/20
 */
public class TestDoWhile {

    public static void main(String[] args) {

        int a = 0;
        int c = 0;

        // do while是先进再判断
        do {
            --c;
            a = a -1;
        } while(a > 0);

        System.out.println(c); //-1

    }

}