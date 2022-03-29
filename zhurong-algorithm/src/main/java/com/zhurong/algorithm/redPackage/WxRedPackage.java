/**
 * @Title: WxRedPackage.java
 * @Package: com.zhurong.algorithm.redPackage
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 https://onezg.cnblogs.com
 */
package com.zhurong.algorithm.redPackage;

/**
 * @description: 微信红包
 * @author LZG
 * @date 2018/11/28
 */
public class WxRedPackage {

    /**
     *  剩余红包的数量
     */
    int remainSize;

    /**
     *  剩余的钱
     */
    double remainMoney;

    public WxRedPackage(int remainSize, double remainMoney) {
        this.remainSize = remainSize;
        this.remainMoney = remainMoney;
    }

    public int getRemainSize() {
        return remainSize;
    }

    public void setRemainSize(int remainSize) {
        this.remainSize = remainSize;
    }

    public double getRemainMoney() {
        return remainMoney;
    }

    public void setRemainMoney(double remainMoney) {
        this.remainMoney = remainMoney;
    }

}