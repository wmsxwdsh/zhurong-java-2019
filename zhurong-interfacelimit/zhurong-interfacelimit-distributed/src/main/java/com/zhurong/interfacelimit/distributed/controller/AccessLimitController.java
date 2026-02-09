package com.zhurong.interfacelimit.distributed.controller;

import com.zhurong.interfacelimit.distributed.annotation.RateLimit;
import com.zhurong.interfacelimit.distributed.service.TestService;
import java.util.Date;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicInteger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Lua+Redis 实现分布式接口限流
 * 2019/7/5
 */
@RestController
public class AccessLimitController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private TestService testService;

    // 10 秒中，可以访问10次
    @RateLimit(key = "test", time = 10, count = 10)
    @GetMapping("/test")
    public String luaLimiter() {

        testService.getResultOne();

        RedisAtomicInteger entityIdCounter = new RedisAtomicInteger("entityIdCounter", redisTemplate.getConnectionFactory());
        String date = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss.SSS");

        return date + " 累计访问次数：" + entityIdCounter.getAndIncrement();
    }

}