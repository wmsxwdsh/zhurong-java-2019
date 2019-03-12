/**
 * @Title: Producer.java
 * @Package: com.zhurong.concurrency.base.blockingqueue
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.concurrency.base.blockingqueue;

import java.util.concurrent.BlockingQueue;

/**
 * @description: 生产者
 * @author LZG
 * @date 2019/3/12
 */
public class Producer implements Runnable {

    BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            String producer = Thread.currentThread().getName();
            System.out.println(producer + ": I have made a product.");

            String temp = "A Product, 生产线程：" + producer;
            queue.put(temp); //如果队列是满的，会阻塞当前线程

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}