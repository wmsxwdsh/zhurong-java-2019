package com.zhurong.concurrency.base.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 列出并发包中的各种线程池
 * 2019/2/27
 */
public class ExecutorDemo {

    public static void main(String[] args) {
        //cpu的数量
        int cpuNums = Runtime.getRuntime().availableProcessors();
        System.out.println(cpuNums);

        //单线程的线程池
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        //可缓存的线程池
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        //固定大小的线程池
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(cpuNums);

        //固定大小的线程池，支持定时、周期性执行任务的需求
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(cpuNums);
        //单线程的线程池，支持定时、周期性执行任务的需求
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    }

}