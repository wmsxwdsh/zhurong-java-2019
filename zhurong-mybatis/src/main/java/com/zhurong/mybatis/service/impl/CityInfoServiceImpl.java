/**
 * @Title: CityServiceImpl.java
 * @Package: com.zhurong.mybatis.service.impl
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.mybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhurong.db.persistence.domain.CityInfo;
import com.zhurong.db.persistence.domain.CityInfoExample;
import com.zhurong.db.persistence.mapper.generic.CityInfoMapper;
import com.zhurong.mybatis.pagehelperplus.PageVO;
import com.zhurong.mybatis.pagehelperplus.parser.SearchConditionParser;
import com.zhurong.mybatis.pagehelperplus.parser.SortConditionParser;
import com.zhurong.mybatis.service.CityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author LZG
 * @date 2019/6/21
 */
@Service
public class CityInfoServiceImpl implements CityInfoService {

    @Autowired
    private CityInfoMapper cityInfoMapper;

    @Override
    public PageVO<CityInfo> pageQueryCityInfoList(PageVO<CityInfo> pageVO) {
        int pageNum = pageVO.getPageInfo().getPageNum();
        int pageSize = pageVO.getPageInfo().getPageSize();

        String orderBy = SortConditionParser.converToOrderBy(pageVO.getSortInfo());

        PageHelper.startPage(pageNum, pageSize, orderBy);
        CityInfoExample example = SearchConditionParser.coverToExample(pageVO.getSearchInfo());

        pageVO.setPageInfo(new PageInfo(cityInfoMapper.selectByExample(example)));
        return pageVO;
    }

}