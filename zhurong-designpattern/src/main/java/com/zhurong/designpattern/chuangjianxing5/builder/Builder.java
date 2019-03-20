/**
 * @Title: Builder.java
 * @Package: com.zhurong.designpattern.chuangjianxing5.builder
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.designpattern.chuangjianxing5.builder;

/**
 * @description: 抽象建造
 * @author LZG
 * @date 2019/3/20
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
     * @return
     */
    public Product buildProduct();

}