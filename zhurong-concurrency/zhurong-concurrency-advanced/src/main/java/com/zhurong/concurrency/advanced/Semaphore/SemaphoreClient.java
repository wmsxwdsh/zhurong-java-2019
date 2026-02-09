package com.zhurong.concurrency.advanced.Semaphore;

import com.zhurong.utils.date.DateUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * semaphore 这个类是用作访问并发控制，可以设置资源最大同时访问的个数。
 * 2019/4/18
 */
public class SemaphoreClient {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(3); //资源最多可被3个线程并发访问
        //Semaphore semaphore2 = new Semaphore(3, false); //fair默认是true，即公平锁，先阻塞的先获取锁

        for (int i = 0; i < 10; i++) {
            final int threadnum = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        /**
                        //尝试获取锁
                        if(semaphore.tryAcquire()){
                            doWork(threadnum);
                            semaphore.release();
                        }
                         */

                        //semaphore.acquire(2); //获取两个许可
                        semaphore.acquire(); //默认一次获取一个许
                        doWork(threadnum);
                        semaphore.release(); //释放许可

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();//如果不shutdown工程不会结束
    }

    //做什么任务你看着办吧，银行柜台、厕所坑位
    private static void doWork(int threadNum) throws Exception {
        System.out.println(DateUtil.getNow(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS) +
                            " 服务号" + threadNum + ", 业务受理中。。。");
        Thread.sleep(3000);
    }

}