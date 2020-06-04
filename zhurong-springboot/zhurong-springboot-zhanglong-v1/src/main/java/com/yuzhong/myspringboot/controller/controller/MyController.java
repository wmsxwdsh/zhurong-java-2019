/**
 * @Title: MyController.java
 * @Package: com.yuzhong.myspringboot.controller
 * @author LZG, liuzhongguo@cdvcloud.com
 * Copyright (c) 2020 https://www.yunshicloud.com
 */
package com.yuzhong.myspringboot.controller.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author LZG
 * @date 2020年03月09日
 */
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