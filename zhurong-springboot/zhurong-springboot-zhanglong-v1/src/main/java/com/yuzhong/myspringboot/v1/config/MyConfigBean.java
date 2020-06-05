/**
 * @Title: MyConfigBean.java
 * @Package: com.zhurong.springboot.config
 * @author LZG, liuzhongguo@cdvcloud.com
 * Copyright (c) 2020 https://www.yunshicloud.com
 */
package com.yuzhong.myspringboot.v1.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * @description:
 * @author LZG
 * @date 2020年03月09日
 */
public class MyConfigBean {

    @Value("${myConfig.myObject.myName}")
    private String myName;

    @Value("${myConfig.myObject.myAge}")
    private String myAge;

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String getMyAge() {
        return myAge;
    }

    public void setMyAge(String myAge) {
        this.myAge = myAge;
    }
}