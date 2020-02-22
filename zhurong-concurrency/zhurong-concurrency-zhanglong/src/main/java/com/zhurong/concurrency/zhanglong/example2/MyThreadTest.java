/**
 * @Title: MyThreadTest.java
 * @Package: com.zhurong.concurrency.zhanglong.example2
 * @author LZG, liuzhongguo@cdvcloud.com
 * Copyright (c) 2020 https://www.yunshicloud.com
 */
package com.zhurong.concurrency.zhanglong.example2;

/**
 * @description:
 * @author LZG
 * @date 2020年02月22日
 */
public class MyThreadTest {

    public static void main(String[] args) {

        Runnable r = new MyThread();

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();
    }

}


class MyThread implements Runnable {

    int x;

    @Override
    public void run() {
        x = 0;

        while(true) {

            System.out.println(++x);

            try {
                Thread.sleep((long)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(x == 30) {
                break;
            }

        }
    }
}