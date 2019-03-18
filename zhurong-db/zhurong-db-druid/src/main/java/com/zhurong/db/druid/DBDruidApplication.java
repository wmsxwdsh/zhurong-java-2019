/**
 * @Title: DBDruidApplication.java
 * @Package: com.zhurong.db.druid
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.db.druid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @description: druid监控台请求地址：http://localhost:9090/testDruid/druid/login.html
 *               用户名：zhurong 密码：123456 --在application.properties里配置
 * @author LZG
 * @date 2019/3/5
 */
@SpringBootApplication
@EnableTransactionManagement //spring boot开启事务
@ServletComponentScan //配置druid必须加的注解
@MapperScan("com.zhurong.db.persistence.mapper.*")
public class DBDruidApplication {

    public static void main(String[] args) {
        SpringApplication.run(DBDruidApplication.class, args);
    }
}