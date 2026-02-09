package com.zhurong.concurrency.base.pool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadFactory implements ThreadFactory {

    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        String threadName = MyThreadFactory.class.getSimpleName() + count.addAndGet(1);
        t.setName("自定义线程工厂的" + threadName + "线程");
        return t;
    }

}
