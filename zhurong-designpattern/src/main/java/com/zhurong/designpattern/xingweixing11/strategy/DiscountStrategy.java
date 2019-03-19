/**   
 * @Title: DiscountStrategy.java
 * @Package: com.zhurong.designpattern.xingweixing11.celuems
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京中数合一科技有限公司
 */
package com.zhurong.designpattern.xingweixing11.strategy;

/**
 * @description: 折扣策略接口
 * @author LZG
 * @date 2019/3/18
 */
public interface DiscountStrategy {

    /**
     * @Description: 计算折扣后的价格
     * @param originalPrice 原来的价格
     * @return double 打完折后的价格
     * @author LZG
     * @date 2019/3/18
     */
    public double calPrice(double originalPrice);
}
