/**   
 * @Title: HelloInterface.java
 * @Package: com.zhurong.jdk.java8.lambda
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.jdk.java8.lambda;

/**
 * @description: 函数式接口
 * @author LZG
 * @date 2019/3/12
 */
@FunctionalInterface
public interface HelloInterface {

    String sayHello(String name);
}