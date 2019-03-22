/**   
 * @Title: MainApplication.java
 * @Package: com.zhurong.solution.beanvalidation
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.solution.beanvalidation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @description: 用postman测试，即本目录下的“postman测试截图”
 *
 * ！！bean validation的内容包含两部分：
 *          --1、zhurong-solution-beanvlidation下的validator package、resources文件夹下的ValidationMessages.properties
 *          --2、zhurong-db-persistence下的validator package、TbBookInfo
 * @author LZG
 * @date 2019/3/21
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