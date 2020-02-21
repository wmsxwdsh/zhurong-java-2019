/**
 * @Title: TestWaitNotify.java
 * @Package: com.zhurong.concurrency.zhanglong
 * @author LZG, liuzhongguo@cdvcloud.com
 * Copyright (c) 2020 https://www.yunshicloud.com
 */
package com.zhurong.concurrency.zhanglong;

/**
 * @description:
 * @author LZG
 * @date 2020年02月21日
 */
public class TestWaitNotify {

    public static void main(String[] args) throws Exception {

        Object o1 = new Object();

        synchronized (o1) {
            o1.wait(5000);
            System.out.println("hello");
        }


    }


}

/**
 *
 * （1）当调用wait时，首先要确保调用了wait方法的线程已经持有了对象的锁。
 * （2）当调用wait后，该线程就会释放掉这个对象的锁，然后进入等待状态（wait set)
 * （3）当线程调用了notify后进入等待状态时，他就可以等待其他线程调用相同对象的notify或notifyAll方法来使得自己被唤醒。
 * （4）一旦线程被其他线程唤醒后，该线程就会与其他线程一同开始竞争这个对象的锁（公平竞争），只有当该线程获取到了该对象的锁后，线程才会继续往下执行。
 * （5）调用wait方法的代码片段需要放在一个synchronized块或是synchronized方法中，这样才可以确保线程在调用wait方法前已经获取到了对象的锁。
 * （6）当调用对象的notify方法时，他会随机唤醒该对象集合（wait set）中的任意一个线程，当某个线程被唤醒后，它就会与其他线程一同竞争对象的锁。
 * （7）当调用对象的notifyAll方法时，它会唤醒该对象集合（wait set）中的所有线程，这些线程被唤醒后，会开始竞争对象的锁。
 * （8）在某一时刻，只有唯一一个线程可以拥有对象的锁。
 */