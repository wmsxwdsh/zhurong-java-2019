package com.zhurong.concurrency.base.blockingqueue;

import java.util.concurrent.BlockingQueue;

/**
 * 生产者
 * 2019/3/12
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
            //如果队列是满的，会阻塞当前线程
            queue.put(temp);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}