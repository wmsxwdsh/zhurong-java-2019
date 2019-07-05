/**
 * @Title: JedisFactory.java
 * @Package: com.zhurong.distributedlock.redis.config
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.distributedlock.redis.config;

import java.lang.reflect.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import redis.clients.jedis.Jedis;

/**
 * @description: Jedis工厂类（单例模式）
 * @author LZG
 * @date 2019/7/5
 */
@Service
public class JedisFactory {

    @Autowired
    private RedisConnectionFactory connectionFactory;

    private static Jedis jedis;

    /**
     * @Description: 获得jedis对象
     *      --严重注意：jedis获取不到，获取不到，获取不到。还没解决！！！
     * @return org.springframework.boot.autoconfigure.data.redis.RedisProperties.Jedis
     * @author LZG
     * @date 2019/7/5
     */
    public Jedis getJedis() {
        //从RedisConnectionFactory中获取Redis连接(JedisConnection实现类),然后使用反射的方法从中取得了Jedis实例
        if (jedis == null) {
            Field jedisField = ReflectionUtils.findField(JedisConnection.class, "jedis");
            ReflectionUtils.makeAccessible(jedisField);
            jedis = (Jedis) ReflectionUtils.getField(jedisField, connectionFactory.getSentinelConnection());
        }
        return jedis;
    }

}