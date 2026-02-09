package com.zhurong.designpattern.xingweixing11.strategy;

public class PrimaryMemberDiscountStrategy implements DiscountStrategy {


    @Override
    public double calPrice(double originalPrice) {
        System.out.println("对于初始会员没有折扣");
        return originalPrice;
    }
}