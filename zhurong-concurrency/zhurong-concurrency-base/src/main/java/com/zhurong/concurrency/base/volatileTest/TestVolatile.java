package com.zhurong.concurrency.base.volatileTest;

/**
 * Volatile关键字，保证可见性和禁止指令重排序，但不保证原子性。
 * 1、可见性
 * 对 volatile 变量的写，会立即刷新到主内存；
 * 对 volatile 变量的读，一定从主内存读取。
 *
 * 在多线程中：
 * 线程可能把变量缓存到寄存器 / CPU 缓存
 * 一个线程改了值，另一个线程可能看不见。
 *
 * 2、禁止指令重排序
 * volatile 会在读写处插入内存屏障（memory barrier）：
 * volatile 写：
 * 写之前的操作 不能被重排到写之后
 * volatile 读：
 * 读之后的操作 不能被重排到读之前
 */
public class TestVolatile {

    public static volatile int numb = 0;

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 100; i++) {

            new Thread(new Runnable() {

                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        numb++;
                    }
                }
            }).start();

        }

        System.out.println(numb);
    }

}
