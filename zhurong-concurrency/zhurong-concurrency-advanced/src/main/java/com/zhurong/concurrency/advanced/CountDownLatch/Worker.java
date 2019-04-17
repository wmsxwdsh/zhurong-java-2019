/**
 * @Title: Worker.java
 * @Package: com.zhurong.concurrency.advanced.CountDownLatch.demo1
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.concurrency.advanced.CountDownLatch;

import com.zhurong.utils.date.DateUtil;
import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author LZG
 * @date 2019/4/17
 */
public class Worker implements Runnable {

    private String workerName;
    private int workTime;

    private CountDownLatch latch;

    public Worker(String workerName, int workTime, CountDownLatch latch) {
        this.workerName = workerName;
        this.workTime = workTime;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Worker " + workerName + " do work begin at " + DateUtil.getNow(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));
        doWork(); //工作了
        System.out.println("Worker " + workerName + " do work complete at " + DateUtil.getNow(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));
        latch.countDown(); //工人完成工作，计数器减一
    }

    //做什么工作你看着办吧
    private void doWork() {
        try {
            Thread.sleep(workTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}