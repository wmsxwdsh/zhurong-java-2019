/**   
 * @Title: PrimaryMemberDiscountStrategy.java
 * @Package: com.zhurong.designpattern.xingweixing11.celuems
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.designpattern.xingweixing11.celuems;

/**
 * @description: 
 * @author LZG
 * @date 2019/3/18
 */
public class PrimaryMemberDiscountStrategy implements DiscountStrategy {


    @Override
    public double calPrice(double originalPrice) {
        System.out.println("对于初始会员没有折扣");
        return originalPrice;
    }
}