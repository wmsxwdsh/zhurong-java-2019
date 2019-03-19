/**   
 * @Title: PriceManager.java
 * @Package: com.zhurong.designpattern.xingweixing11.celuems
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.designpattern.xingweixing11.strategy;

/**
 * @description: 价格管理器
 * @author LZG
 * @date 2019/3/18
 */
public class PriceManager {

    private DiscountStrategy discountStrategy;

    public PriceManager(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calPrice(double originalPrice) {
        return discountStrategy.calPrice(originalPrice);
    }
}