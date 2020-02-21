/**
 * @Title: MyObject.java
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
public class MyObject {

    private int counter;


    public synchronized void increase() {

//        if(counter != 0) {
        while(counter != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        counter++;
        System.out.println(counter);

        notify();
    }

    public synchronized void decrease() {

//        if(counter == 0) {
        while(counter == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        counter--;
        System.out.println(counter);

        notify();
    }



}


/**
 * 编写一个多线程的程序，实现如下目标：
 * 1、存在一个对象，该对象有一个int类型的成员变量counter，counter = 0
 * 2、创建两个线程，其中一个线程对该对象的成员变量counter值增1，
 *   另一个线程对该对象的成员变量counter减1
 * 3、输出该对象counter每次变化后的值
 * 4、最终输出结果为：10101010……
 */