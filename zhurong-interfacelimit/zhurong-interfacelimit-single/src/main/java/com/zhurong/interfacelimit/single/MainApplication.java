/**   
 * @Title: MainApplication.java
 * @Package: com.zhurong.mybatis
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.interfacelimit.single;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @description: 
 * @author LZG
 * @date 2019/7/5
 */
@SpringBootApplication
@ServletComponentScan //配置druid必须加的注解
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

}