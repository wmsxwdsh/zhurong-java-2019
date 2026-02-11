package com.zhurong.interfacelimit.single.service;

public interface AccessLimitService {

    /**
     * 尝试获取令牌
     */
    boolean tryAcquire();
}