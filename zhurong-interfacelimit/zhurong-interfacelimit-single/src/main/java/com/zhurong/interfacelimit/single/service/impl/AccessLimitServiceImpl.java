/**   
 * @Title: AccessLimitServiceImpl.java
 * @Package: com.zhurong.interfacelimit.single.service.impl
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.interfacelimit.single.service.impl;

import com.google.common.util.concurrent.RateLimiter;
import com.zhurong.interfacelimit.single.service.AccessLimitService;
import org.springframework.stereotype.Service;

/**
 * @description: 
 * @author LZG
 * @date 2019/7/5
 */
@Service
public class AccessLimitServiceImpl implements AccessLimitService {

    //每秒只发出5个令牌
    private RateLimiter rateLimiter = RateLimiter.create(5.0);

    /**
     * @Description: 尝试获取令牌
     * @return boolean
     * @author LZG
     * @date 2019/7/5
     */
    @Override
    public boolean tryAcquire() {
        return rateLimiter.tryAcquire();
    }

}