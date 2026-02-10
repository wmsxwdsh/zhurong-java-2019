package com.zhurong.mybatis.controller;

import com.zhurong.db.persistence.domain.CityInfo;
import com.zhurong.mybatis.pagehelperplus.PageVO;
import com.zhurong.mybatis.service.CityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模糊查询、分页查询、结果排序，完整演示。
 * -- pagehelp-plus说明.txt 例子
 * 2019/6/21
 */
@RestController
@RequestMapping("/cityInfo")
public class CityInfoController {

    @Autowired
    private CityInfoService cityInfoService;

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public PageVO<CityInfo> getPageProjectDataSource(@RequestBody PageVO<CityInfo> pageVO) {
        return cityInfoService.pageQueryCityInfoList(pageVO);
    }

}