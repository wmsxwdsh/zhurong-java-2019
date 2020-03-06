/**
 * @Title: McwPool.java
 * @Package: com.zhurong.concurrency.base.pool
 * @author LZG, liuzhongguo@cdvcloud.com
 * Copyright (c) 2020 https://www.yunshicloud.com
 */
package com.zhurong.concurrency.base.pool;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author LZG
 * @description: 马才伟试验例子
 * @date 2020年03月06日
 */
public class McwPool {

    @Test
    public void test1() throws InterruptedException {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3, 3, 2,
                TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(10));

//        threadPoolExecutor.prestartAllCoreThreads();

        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "执行完了");
                }
            });
        }

    }
}

/**
 * 新方东面试题：
 * <p>
 * 线程池 假如我现在核心线程数5 最大线程数10 阻塞队列50
 * 如果来了一个task 启了一个线程并且执行完了 然后又来了一个任务
 * 它会使用之前那个线程还是重新创建一个线程？
 */