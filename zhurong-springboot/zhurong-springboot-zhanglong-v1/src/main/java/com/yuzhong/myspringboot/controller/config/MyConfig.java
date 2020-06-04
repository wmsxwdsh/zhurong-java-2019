/**
 * @Title: MyConfig.java
 * @Package: com.zhurong.springboot.config
 * @author LZG, liuzhongguo@cdvcloud.com
 * Copyright (c) 2020 https://www.yunshicloud.com
 */
package com.yuzhong.myspringboot.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: //@Lazy  //延迟加载
 * @author LZG
 * @date 2020年03月09日
 */
@Configuration
public class MyConfig {

    @Bean
    public MyConfigBean myConfigBean() {
        return new MyConfigBean();
    }

}