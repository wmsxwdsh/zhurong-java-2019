/**
 * @Title: MainApplication.java
 * @Package: com.zhurong.springboot
 * @author LZG, liuzhongguo@cdvcloud.com
 * Copyright (c) 2020 https://www.yunshicloud.com
 */
package com.zhurong.springboot.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description:
 * @author LZG
 * @date 2020年03月09日
 */
@SpringBootApplication
//@EnableSwagger2
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

}