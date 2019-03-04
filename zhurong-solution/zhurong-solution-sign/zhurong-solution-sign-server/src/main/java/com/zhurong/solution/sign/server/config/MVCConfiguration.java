/**
 * @Title: MVCConfiguration.java
 * @Package: com.zhurong.solution.sign.server.config
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.solution.sign.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description:
 * @author LZG
 * @date 2019/3/4
 */
@Configuration
public class MVCConfiguration implements WebMvcConfigurer {

    @Bean
    public VerifySignInterceptor verifySignInterceptor() {
        return new VerifySignInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(verifySignInterceptor()).excludePathPatterns("/static/*")
            .excludePathPatterns("/error").addPathPatterns("/**");
    }

}