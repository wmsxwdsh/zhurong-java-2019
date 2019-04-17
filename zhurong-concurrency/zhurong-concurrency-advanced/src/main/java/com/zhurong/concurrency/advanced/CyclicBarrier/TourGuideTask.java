/**   
 * @Title: TourGuideTask.java
 * @Package: com.zhurong.concurrency.advanced.CyclicBarrier
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.concurrency.advanced.CyclicBarrier;

/**
 * @description: 导游线程，都到达目的地时，发放护照和签证
 * @author LZG
 * @date 2019/4/17
 */
public class TourGuideTask implements Runnable {

    @Override
    public void run() {
        System.out.println("****导游分发护照签证****");
        try {
            //模拟发护照签证需要2秒
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}