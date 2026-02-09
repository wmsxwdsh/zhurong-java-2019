package com.zhurong.concurrency.zhanglong.example3;

/**
 * 锁粗化
 * 2020年02月27日
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