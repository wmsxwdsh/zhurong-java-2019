/**   
 * @Title: Commons.java
 * @Package: com.zhurong.interfacelimit.distributed.config
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.interfacelimit.distributed.config;

import java.io.Serializable;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

/**
 * @description: 公共配置
 * @author LZG
 * @date 2019/7/5
 */
@Component
public class Commons {

    /**
     * @Description: 读取限流脚Lua脚本
     * @return org.springframework.data.redis.core.script.DefaultRedisScript<java.lang.Number>
     * @author LZG
     * @date 2019/7/5
     */
    @Bean
    public DefaultRedisScript<Number> redisluaScript() {
        DefaultRedisScript<Number> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("rateLimit.lua")));
        redisScript.setResultType(Number.class);
        return redisScript;
    }

    /**
     * @Description: RedisTemplate
     * @param redisConnectionFactory
     * @return org.springframework.data.redis.core.RedisTemplate<java.lang.String,java.io.Serializable>
     * @author LZG
     * @date 2019/7/5
     */
    @Bean
    public RedisTemplate<String, Serializable> limitRedisTemplate(LettuceConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Serializable> template = new RedisTemplate<String, Serializable>();
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

}