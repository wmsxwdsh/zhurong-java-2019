/**   
 * @Title: EnumSingleton.java
 * @Package: com.zhurong.designpattern.chuangjianxing5.singleton
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.designpattern.chuangjianxing5.singleton;

/**
 * @description: 用枚举实现单例
 * @author LZG
 * @date 2019/3/18
 */
public enum  EnumSingleton {

    //定义一个枚举的元素，它就代表了EnumSignleton的一个实例
    hello;

    //单例可以有自己的操作
    public void operation() {
        System.out.println("invoked EnumSingleton operation method");
    }

}