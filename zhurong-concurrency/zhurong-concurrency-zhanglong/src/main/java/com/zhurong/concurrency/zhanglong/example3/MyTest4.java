package com.zhurong.concurrency.zhanglong.example3;

/**
 * 锁消除
 * 2020年02月27日
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