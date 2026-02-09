package com.zhurong.designpattern.xingweixing11.strategy;

public class IntermediateMemberDiscountStrategy implements DiscountStrategy {

    @Override
    public double calPrice(double originalPrice) {
        System.out.println("对于中级会员折扣为10%");
        return originalPrice * 0.9;
    }
}