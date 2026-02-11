package com.zhurong.myspring.service.impl;

import com.zhurong.myspring.service.SayHelloService;
import org.springframework.stereotype.Service;

@Service
public class SayHelloServiceImpl implements SayHelloService {

    @Override
    public String sayHello(String name) {
        return "hello, " + name;
    }

    /**
     * 跟世界打招呼
     */
    @Override
    public String sayWorld(String name) {
        return null;
    }
}