package com.yuzhong.myspringboot.v1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

//    @Autowired
//    private MyConfigBean myConfigBean;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Object test() {
//        System.out.println(myConfigBean.getMyName());
//        System.out.println(myConfigBean.getMyAge());

        return "hello world";
    }



}