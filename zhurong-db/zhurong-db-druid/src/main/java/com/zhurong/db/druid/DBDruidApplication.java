package com.zhurong.db.druid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * druid 监控台请求地址：http://localhost:9090/testDruid/druid/login.html
 *      用户名：zhurong 密码：123456 --在 application.properties 里配置
 * 2019/3/5
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