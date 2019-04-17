/**
 * @Title: Client.java
 * @Package: com.zhurong.concurrency.advanced.CyclicBarrier
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.concurrency.advanced.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @description:
 *
  举个报旅行团旅行的例子。
  --出发时，导游会在机场收了护照和签证，办理集体出境手续，所以，要等大家都到齐才能出发，出发前再把护照和签证发到大家手里。
    对应CyclicBarrier使用。每个人到达后进入barrier状态。
  --都到达后，唤起大家一起出发去旅行。
  --旅行出发前，导游还会有个发护照和签证的动作。

 *
 * @author LZG
 * @date 2019/4/17
 */
public class Client {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new TourGuideTask());

        Executor executor = Executors.newFixedThreadPool(3);
        executor.execute(new TravelTask("张三", 5, cyclicBarrier));
        executor.execute(new TravelTask("李四", 3, cyclicBarrier));
        executor.execute(new TravelTask("王五", 8, cyclicBarrier));

        /**
         * 输出结果：

         李四到达集合点
         张三到达集合点
         王五到达集合点
         ****导游分发护照签证****
         王五开始旅行啦～～
         张三开始旅行啦～～
         李四开始旅行啦～～

         */
    }

}