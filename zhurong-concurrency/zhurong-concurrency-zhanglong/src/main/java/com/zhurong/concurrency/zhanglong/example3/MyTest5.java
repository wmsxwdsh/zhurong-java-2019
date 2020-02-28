/**
 * @Title: MyTest5.java
 * @Package: com.zhurong.concurrency.zhanglong.example3
 * @author LZG, liuzhongguo@cdvcloud.com
 * Copyright (c) 2020 https://www.yunshicloud.com
 */
package com.zhurong.concurrency.zhanglong.example3;

/**
 * @description: 锁粗化
 * @author LZG
 * @date 2020年02月27日
 */
public class MyTest5 {

    private Object object = new Object();

    public void method() {

        synchronized (object) {
            System.out.println("hello world");
        }

        synchronized (object) {
            System.out.println("welcome");
        }

        synchronized (object) {
            System.out.println("person");
        }

    }

}