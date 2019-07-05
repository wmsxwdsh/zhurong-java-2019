/**   
 * @Title: TestServiceImpl.java
 * @Package: com.zhurong.interfacelimit.distributed.service.impl
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.interfacelimit.distributed.service.impl;

import com.zhurong.interfacelimit.distributed.service.TestService;
import com.zhurong.utils.response.edop.EdopResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @description: 
 * @author LZG
 * @date 2019/7/5
 */
@Service
public class TestServiceImpl implements TestService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void getResultOne() {
        logger.info("调用了方法getResultOne");
    }

    @Override
    public void getResultTwo() {
        logger.info("调用了方法getResultTwo");
    }
}