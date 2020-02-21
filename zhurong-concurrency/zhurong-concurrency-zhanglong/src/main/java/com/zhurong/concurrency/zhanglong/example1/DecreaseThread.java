/**
 * @Title: DecreaseThread.java
 * @Package: com.zhurong.concurrency.zhanglong.example1
 * @author LZG, liuzhongguo@cdvcloud.com
 * Copyright (c) 2020 https://www.yunshicloud.com
 */
package com.zhurong.concurrency.zhanglong.example1;

/**
 * @description:
 * @author LZG
 * @date 2020年02月21日
 */
public class DecreaseThread implements Runnable {

    private MyObject myObject;

    public DecreaseThread(MyObject myObject) {
        this.myObject = myObject;
    }

    public void run() {

        for(int i = 0; i < 30; i++) {
            try {
                Thread.sleep((long)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            myObject.decrease();
        }

    }

}