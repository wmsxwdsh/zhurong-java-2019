/**   
 * @Title: Director.java
 * @Package: com.zhurong.designpattern.chuangjianxing5.builder
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.designpattern.chuangjianxing5.builder;

/**
 * @description: 建造者（导演）
 * @author LZG
 * @date 2019/3/20
 */
public class Director {

    public Product constructProduct(ConcreteBuilder concreteBuilder){
        concreteBuilder.buildBasic();
        concreteBuilder.buildWalls();
        concreteBuilder.roofed();
        return concreteBuilder.buildProduct();
    }

}