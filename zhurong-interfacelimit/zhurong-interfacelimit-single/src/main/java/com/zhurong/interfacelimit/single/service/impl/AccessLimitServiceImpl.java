package com.zhurong.interfacelimit.single.service.impl;

import com.google.common.util.concurrent.RateLimiter;
import com.zhurong.interfacelimit.single.service.AccessLimitService;
import org.springframework.stereotype.Service;

@Service
public class AccessLimitServiceImpl implements AccessLimitService {

    //每秒只发出5个令牌
    private RateLimiter rateLimiter = RateLimiter.create(5.0);

    /**
     * 尝试获取令牌
     */
    @Override
    public boolean tryAcquire() {
        return rateLimiter.tryAcquire();
    }

}