/**   
 * @Title: TestBlockingQueue.java
 * @Package: com.zhurong.concurrency.base.blockingqueue
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.concurrency.base.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @description: 
 * @author LZG
 * @date 2019/3/12
 */
public class TestBlockingQueue {

    public static void main(String[] args) {

        BlockingQueue<String> queue = new LinkedBlockingQueue<String>(2);
        // 不设置的话，LinkedBlockingQueue默认大小为Integer.MAX_VALUE
        // BlockingQueue<String> queue = new LinkedBlockingQueue<String>();

        // BlockingQueue<String> queue = new ArrayBlockingQueue<String>(2);

        Consumer consumer = new Consumer(queue);
        Producer producer = new Producer(queue);
        for (int i = 0; i < 3; i++) {
            new Thread(producer, "Producer" + (i + 1)).start();
        }
		for (int i = 0; i < 5; i++) {
			new Thread(consumer, "Consumer" + (i + 1)).start();
		}

    }
}