package com.zhurong.solution.sign.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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