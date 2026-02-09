package com.zhurong.designpattern.xingweixing11.strategy;

public class AdvancedMemberDiscountStrategy implements DiscountStrategy {

    @Override
    public double calPrice(double originalPrice) {
        System.out.println("对于高级会员折扣为20%");
        return  originalPrice * 0.8;
    }
}