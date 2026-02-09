package com.zhurong.concurrency.base.deadLock;

/**
 * 死锁示例
 * -- 运行后后台会一直在运行，必须手动停掉。
 * 2019/2/28
 */
public class DeadLockDemo {

    private static String resource_a = "A";
    private static String resource_b = "B";

    public static void main(String[] args) {

        new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (resource_a) {
                    System.out.println("get resource_a");
                    try {
                        Thread.sleep(3000); //3000毫秒
                        synchronized (resource_b) {
                            System.out.println("get resource_b");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        //lambda表达式()表示的是函数式接口需要的参数
        new Thread(() ->{
            synchronized (resource_b) {
                System.out.println("get resource_b");
                try {
                    Thread.sleep(3000); //3000毫秒
                    synchronized (resource_a) {
                        System.out.println("resource_a");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }).start();

    }

}