package com.zhurong.concurrency.zhanglong.example3;

/**
 * 查看字节码
 * 2020年02月22日
 */
public class MyTest1 {

    private Object object = new Object();

    public void method1() {
        synchronized (object) {
            System.out.println("hello world");

            throw new RuntimeException();
        }
    }

    public void method2() {
        synchronized (object) {
            System.out.println("welcome");
        }
    }


}