/**   
 * @Title: JerseyApplication.java
 * @Package: com.zhurong.jersey
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.jersey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description: 访问地址：http://localhost:9090/jersey/rest/hello/test
 * @author LZG
 * @date 2019/7/8
 */
@SpringBootApplication
public class JerseyApplication {

    public static void main(String[] args) {
        SpringApplication.run(JerseyApplication.class, args);
    }

}