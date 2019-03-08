/**   
 * @Title: MerchUserService.java
 * @Package: com.zhurong.db.druid.service
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.db.druid.service;

import com.zhurong.db.persistence.domain.MerchUser;

/**
 * @description: 
 * @author LZG
 * @date 2019/3/7
 */
public interface MerchUserService {

    void insert(MerchUser merchUser);
}