package com.zhurong.concurrency.zhanglong.deadlock;

/**
 * 死锁
 * 2020年02月28日
 */
public class DeadLock {

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void myMethod1() {
        synchronized (lock1) {
            synchronized (lock2) {
                System.out.println("myMethod1 invoked");
            }
        }
    }

    public void myMethod2() {
        synchronized (lock2) {
            synchronized (lock1) {
                System.out.println("myMethod2 invoked");
            }
        }
    }


    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();

        Runnable runnable1 = () -> {
            while(true) {
                deadLock.myMethod1();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };

        Thread thread1 = new Thread(runnable1, "myThread1");


        Runnable runnable2 = () -> {
            while(true) {
                deadLock.myMethod2();
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };

        Thread thread2 = new Thread(runnable2, "myThread2");

        thread1.start();
        thread2.start();

    }

}

