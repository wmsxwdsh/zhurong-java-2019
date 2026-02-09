package com.zhurong.designpattern.chuangjianxing5.builder;

/**
 * 建造者（导演）
 * 2019/3/20
 */
public class Director {

    public Product constructProduct(ConcreteBuilder concreteBuilder){
        concreteBuilder.buildBasic();
        concreteBuilder.buildWalls();
        concreteBuilder.roofed();
        return concreteBuilder.buildProduct();
    }

}