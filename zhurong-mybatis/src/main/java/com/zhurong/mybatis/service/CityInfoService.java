/**   
 * @Title: CityInfoService.java
 * @Package: com.zhurong.mybatis.service
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.mybatis.service;

import com.zhurong.db.persistence.domain.CityInfo;
import com.zhurong.mybatis.pagehelperplus.PageVO;

/**
 * @description: 
 * @author LZG
 * @date 2019/6/21
 */
public interface CityInfoService {

    PageVO<CityInfo> pageQueryCityInfoList(PageVO<CityInfo> pageVO);
}