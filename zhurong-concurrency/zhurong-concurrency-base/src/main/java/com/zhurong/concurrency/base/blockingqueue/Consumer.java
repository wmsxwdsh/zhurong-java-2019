package com.zhurong.concurrency.base.blockingqueue;

import java.util.concurrent.BlockingQueue;

/**
 * 消费者
 * 2019/3/12
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