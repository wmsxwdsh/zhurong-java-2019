package com.zhurong.mybatis.service;

import com.zhurong.db.persistence.domain.CityInfo;
import com.zhurong.mybatis.pagehelperplus.PageVO;

public interface CityInfoService {

    PageVO<CityInfo> pageQueryCityInfoList(PageVO<CityInfo> pageVO);
}