/**
 * @Title: MyTest1.java
 * @Package: com.zhurong.concurrency.zhanglong.lock
 * @author LZG, liuzhongguo@cdvcloud.com
 * Copyright (c) 2020 https://www.yunshicloud.com
 */
package com.zhurong.concurrency.zhanglong.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author LZG
 * @date 2020年02月29日
 */
public class MyTest1 {

    private Lock lock = new ReentrantLock(); //可重入锁

    public void myMethod1() {
        try {
            lock.lock();
            System.out.println("myMethod1 invoked.");
        } finally {
            //这行取消是什么结果
            //可重入锁，第二次执行获取锁可以获取到，因为是可重入锁
//            lock.unlock();

        }
    }

    public void myMethod2() {
//        try {
//            lock.lock();
//            System.out.println("myMethod2 invoked.");
//        } finally {
//            lock.unlock();
//        }

        boolean result = false;

        try {
            result = lock.tryLock(800, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(result) {
            System.out.println("get the lock.");
        } else {
            System.out.println("cant't get the lock.");
        }

    }

    public static void main(String[] args) {
        MyTest1 myTest1 = new MyTest1();

        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 10; i++) {
                myTest1.myMethod1();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 10; i++) {
                myTest1.myMethod2();
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }

}