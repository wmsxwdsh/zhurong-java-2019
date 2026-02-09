package com.zhurong.designpattern.chuangjianxing5.builder;

/**
 * 抽象建造
 * 2019/3/20
 */
public interface Builder {

    /**
     * 打基础
     */
    public void buildBasic();

    /**
     * 砌墙
     */
    public void buildWalls();

    /**
     * 封顶
     */
    public void roofed();

    /**
     * 造房子
     */
    public Product buildProduct();

}