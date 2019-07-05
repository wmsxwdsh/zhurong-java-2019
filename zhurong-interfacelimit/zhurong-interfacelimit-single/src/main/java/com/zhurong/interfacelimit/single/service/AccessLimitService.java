/**
 * @Title: AccessLimitService.java
 * @Package: com.zhurong.interfacelimit.single.service
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.interfacelimit.single.service;

/**
 * @description:
 * @author LZG
 * @date 2019/7/5
 */
public interface AccessLimitService {

    /**
     * @Description: 尝试获取令牌
     * @return boolean
     * @author LZG
     * @date 2019/7/5
     */
    boolean tryAcquire();
}