/**   
 * @Title: TestService.java
 * @Package: com.zhurong.interfacelimit.distributed.service
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.interfacelimit.distributed.service;

import com.zhurong.utils.response.edop.EdopResponse;

/**
 * @description: 
 * @author LZG
 * @date 2019/7/5
 */
public interface TestService {
    EdopResponse getResultOne();
    EdopResponse getResultTwo();
}