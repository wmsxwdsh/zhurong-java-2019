package com.zhurong.designpattern.xingweixing11.strategy;

/**
 * 折扣策略接口
 * 2019/3/18
 */
public interface DiscountStrategy {

    /**
     * 计算折扣后的价格
     * @param originalPrice 原来的价格
     * @return double 打完折后的价格
     */
    public double calPrice(double originalPrice);
}
