/**   
 * @Title: SayHelloServiceImpl.java
 * @Package: com.zhurong.myspring.service.impl
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 https://onezg.cnblogs.com
 */
package com.zhurong.myspring.service.impl;

import com.zhurong.myspring.service.SayHelloService;
import org.springframework.stereotype.Service;

/**
 * @description: 
 * @author LZG
 * @date 2019/10/23
 */
@Service
public class SayHelloServiceImpl implements SayHelloService {

    @Override
    public String sayHello(String name) {
        return "hello, " + name;
    }
}