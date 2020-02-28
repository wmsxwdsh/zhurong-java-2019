/**
 * @Title: MyTest4.java
 * @Package: com.zhurong.concurrency.zhanglong.example3
 * @author LZG, liuzhongguo@cdvcloud.com
 * Copyright (c) 2020 https://www.yunshicloud.com
 */
package com.zhurong.concurrency.zhanglong.example3;

/**
 * @description: 锁消除
 * @author LZG
 * @date 2020年02月27日
 */
public class MyTest4 {

//    private Object object = new Object();

    public void method() {

        Object object = new Object();

        synchronized (object) {
            System.out.println("hello world");
        }
    }

}