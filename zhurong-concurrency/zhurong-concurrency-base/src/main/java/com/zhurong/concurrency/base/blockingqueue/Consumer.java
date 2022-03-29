/**
 * @Title: Consumer.java
 * @Package: com.zhurong.concurrency.base.blockingqueue
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.concurrency.base.blockingqueue;

import java.util.concurrent.BlockingQueue;

/**
 * @description: 消费者
 * @author LZG
 * @date 2019/3/12
 */
public class Consumer implements Runnable {

    BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        try {
            String consumer = Thread.currentThread().getName();
            //如果队列为空，会阻塞当前线程
            String temp = queue.take();

            System.out.println(consumer + " get a product: " + temp);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}