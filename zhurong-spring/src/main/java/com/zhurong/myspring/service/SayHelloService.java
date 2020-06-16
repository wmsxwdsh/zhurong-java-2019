/**   
 * @Title: SayHelloService.java
 * @Package: com.zhurong.myspring.service
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 https://onezg.cnblogs.com
 */
package com.zhurong.myspring.service;

/**
 * @author LZG
 * @description: 
 * @date 2019/10/23
 */
public interface SayHelloService {

    String sayHello(String name);

    /**
     * @Description: 跟世界打招呼
     * @param name :
     * @return : java.lang.String
     * @author LZG
     * @date 2020/6/16
     */
    String sayWorld(String name);

}