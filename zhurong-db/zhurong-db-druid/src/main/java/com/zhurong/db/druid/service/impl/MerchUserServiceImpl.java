/**   
 * @Title: MerchUserServiceImpl.java
 * @Package: com.zhurong.db.druid.service.impl
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.db.druid.service.impl;

import com.zhurong.db.druid.service.MerchUserService;
import com.zhurong.db.persistence.domain.MerchUser;
import com.zhurong.db.persistence.mapper.generic.MerchUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 
 * @author LZG
 * @date 2019/3/7
 */
@Service
public class MerchUserServiceImpl implements MerchUserService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MerchUserMapper merchUserMapper;

    @Override
    public void insert(MerchUser merchUser) {
        merchUserMapper.insert(merchUser);
        logger.info("{}插入成功", "zhurong-db-druid");
    }
}