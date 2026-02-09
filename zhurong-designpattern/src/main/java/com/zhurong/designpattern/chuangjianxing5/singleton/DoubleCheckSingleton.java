package com.zhurong.designpattern.chuangjianxing5.singleton;

/**
 * 双重检查索 单例。实现了延迟加载和线程安全
 * 2019/3/18
 */
public class DoubleCheckSingleton {

    //被volatile修饰的变量，不会被本地缓存，对该变量的读写都会共享缓存，从而保证多个线程能正确得处理该变量
    private volatile static DoubleCheckSingleton doubleCheckSingleton = null;

    public static DoubleCheckSingleton getInstance() {

        //先检查实例是否存在，如果不存在才进入下面的同步块
        if (null == doubleCheckSingleton) {

            //同步块，线程安全的创建实例
            synchronized (DoubleCheckSingleton.class) {

                //再次检查实例是否存在，如果不存在才真正的创建实例
                if (null == doubleCheckSingleton) {
                    doubleCheckSingleton = new DoubleCheckSingleton();
                }
            }
        }

        return doubleCheckSingleton;

    }

}