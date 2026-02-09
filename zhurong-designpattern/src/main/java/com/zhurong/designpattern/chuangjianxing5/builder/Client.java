package com.zhurong.designpattern.chuangjianxing5.builder;

/**
 * 2019/3/20
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