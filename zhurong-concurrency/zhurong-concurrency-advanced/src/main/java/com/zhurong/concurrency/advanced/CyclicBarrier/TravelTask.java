package com.zhurong.concurrency.advanced.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 旅行线程
 * 2019/4/17
 */
public class TravelTask implements Runnable {

    private String name; //姓名
    private int arriveTime;//赶到的时间
    private CyclicBarrier cyclicBarrier;

    public TravelTask(String name, int arriveTime, CyclicBarrier cyclicBarrier) {
        this.name = name;
        this.arriveTime = arriveTime;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            //模拟达到需要花的时间
            Thread.sleep(arriveTime * 1000);
            System.out.println(name + "到达集合点");

            cyclicBarrier.await();

            System.out.println(name + "开始旅行啦～～");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}