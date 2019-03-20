/**
 * @Title: Client.java
 * @Package: com.zhurong.designpattern.chuangjianxing5.builder
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.designpattern.chuangjianxing5.builder;

/**
 * @description:
 * @author LZG
 * @date 2019/3/20
 */
public class Client {

    public static void main(String[] args) {

        Director director = new Director();
        Product product = director.constructProduct(new ConcreteBuilder());
        System.out.println(product.getBasic());
        System.out.println(product.getWall());
        System.out.println(product.getRoofed());

    }

}