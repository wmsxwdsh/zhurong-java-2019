/**   
 * @Title: TestHelloInterface.java
 * @Package: com.zhurong.jdk.java8.lambda
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.jdk.java8.lambda;

/**
 * @description: 
 * @author LZG
 * @date 2019/3/12
 */
public class TestHelloInterface {

    public static void main(String[] args) {

        //String name是函数式方法需要的参数。
        HelloInterface helloInterface = (String name) -> "hello " + name;

        System.out.println(helloInterface.sayHello("叶孤城"));
    }
}