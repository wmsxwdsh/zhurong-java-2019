/**
 * @Title: MyController.java
 * @Package: com.zhurong.springboot.controller
 * @author LZG, liuzhongguo@cdvcloud.com
 * Copyright (c) 2020 https://www.yunshicloud.com
 */
package com.zhurong.springboot.test.controller;

import com.zhurong.springboot.test.config.MyConfigBean;
import com.zhurong.springboot.test.domain.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @description:
 * @author LZG
 * @date 2020年03月09日
 */
@RestController
@RequestMapping("/api")
public class MyController {

    @Value("${myConfig.myObject.myName}")
    private String myName;

    @Value("${myConfig.myObject.myAge}")
    private String myAge;

    @Autowired
    private MyConfigBean myConfigBean;

    @ApiOperation(value = "获取用户value", notes = "获取用户notes")
    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public Object getPerson() {
        Person person = new Person();
        person.setId(3);
        person.setName("张三");
        person.setBirthday(new Date());

        System.out.println("@value注解配置的输出---------");
        System.out.println(myName);
        System.out.println(myAge);

        System.out.println("bean对象配置的输出-----------");
        System.out.println(myConfigBean.getMyName());
        System.out.println(myConfigBean.getMyAge());

        return person;
    }

}