package com.zhurong.designpattern.xingweixing11.strategy;

/**
 * 价格管理器
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