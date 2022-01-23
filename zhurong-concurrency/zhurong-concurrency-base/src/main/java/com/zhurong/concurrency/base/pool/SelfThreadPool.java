package com.zhurong.concurrency.base.pool;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * 自定义线程池
 * @author liuzhongguo
 */
public class SelfThreadPool {

    /**
     * 线程池4种拒绝策略
     */
    public void  rejectHandlerList() {
        RejectedExecutionHandler rejectHandler = null;

        // 默认，队列满了丢任务抛出异常
        rejectHandler = new ThreadPoolExecutor.AbortPolicy();

        // 队列满了，丢任务不抛出异常
        rejectHandler = new ThreadPoolExecutor.DiscardPolicy();

        // 将最早进入队列的任务删除，之后再尝试加入队列
        rejectHandler = new ThreadPoolExecutor.DiscardOldestPolicy();

        // 如果添加到线程池失败，那么主线程会自己去执行该任务，如果执行程序已关闭（主线程运行结束），则会丢弃任务
        rejectHandler = new ThreadPoolExecutor.CallerRunsPolicy();
    }

    @Test
    public void test1() {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2, 3, 100000, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), new MyThreadFactory(),
                new MyRejectedExecutionHandler());

        for (int i = 0; i < 10; i++) {
            int temp = i;
            threadPool.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " 执行任务:" + temp);

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        }

        //让主线程持续运行
        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
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