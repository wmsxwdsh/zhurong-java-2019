/**
 * @Title: WorkerCountDownLatchMain.java
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
public class WorkerCountDownLatchMain {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("all work begin at " + DateUtil.getNow(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));

        //两个工人的协作
        CountDownLatch latch = new CountDownLatch(2); 

        Thread worker1 = new Thread(new Worker("祝融", 5000, latch));
        Thread worker2 = new Thread(new Worker("共工", 10000, latch));

        worker1.start();
        worker2.start();

        latch.await();//等待所有工人完成工作
        System.out.println("all work done at " + DateUtil.getNow(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));
    }

}