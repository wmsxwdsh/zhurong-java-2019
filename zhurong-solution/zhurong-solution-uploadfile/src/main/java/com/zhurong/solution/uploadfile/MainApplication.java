/**   
 * @Title: MainApplication.java
 * @Package: com.zhurong.solution.uploadfile
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.solution.uploadfile;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @description: 
 * @author LZG
 * @date 2019/6/2
 */
@SpringBootApplication
@EnableTransactionManagement //spring boot开启事务
@ServletComponentScan //配置druid必须加的注解
@MapperScan("com.zhurong.db.persistence.mapper.*")
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

}