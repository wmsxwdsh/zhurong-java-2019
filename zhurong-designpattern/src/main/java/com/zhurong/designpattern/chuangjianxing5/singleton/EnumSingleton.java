package com.zhurong.designpattern.chuangjianxing5.singleton;

/**
 * 用枚举实现单例
 * 2019/3/18
 */
public enum  EnumSingleton {

    //定义一个枚举的元素，它就代表了EnumSignleton的一个实例
    hello;

    //单例可以有自己的操作
    public void operation() {
        System.out.println("invoked EnumSingleton operation method");
    }

}