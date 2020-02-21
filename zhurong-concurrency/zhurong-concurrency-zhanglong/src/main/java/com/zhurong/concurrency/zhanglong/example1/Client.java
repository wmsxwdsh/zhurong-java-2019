/**
 * @Title: Client.java
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
public class Client {

    public static void main(String[] args) {

        MyObject myObject = new MyObject();

        Thread increaseThread = new Thread(new IncreaseThread(myObject));
        Thread decreaseThread = new Thread(new DecreaseThread(myObject));

        Thread increaseThread2 = new Thread(new IncreaseThread(myObject));
        Thread decreaseThread2 = new Thread(new DecreaseThread(myObject));


        increaseThread.start();
        decreaseThread.start();

        increaseThread2.start();
        decreaseThread2.start();

    }

}