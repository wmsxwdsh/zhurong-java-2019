package com.zhurong.concurrency.advanced.CyclicBarrier;

/**

 简介：
 CyclicBarrier是JDK1.5开始提供的并发编程，辅助工具类。

 字面意思回环栅栏，通过它可以实现让一组线程等待至某个状态之后再全部同时执行。
 叫做回环是因为当所有等待线程都被释放以后，CyclicBarrier可以被重用。
 叫做栅栏，大概是描述所有线程被栅栏挡住了，当都达到时，一起跳过栅栏执行，也算形象。我们可以把这个状态就叫做barrier。





 */