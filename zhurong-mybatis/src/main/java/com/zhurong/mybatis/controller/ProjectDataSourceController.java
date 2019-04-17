/**   
 * @Title: ProjectDataSourceController.java
 * @Package: com.zhurong.mybatis
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.mybatis.controller;

import com.zhurong.db.persistence.domain.ProjectDataSource;
import com.zhurong.mybatis.service.ProjectDataSourceService;
import com.zhurong.utils.response.InfoCoinResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: pageHelper分页demo
 *      --请求地址：http://localhost:9090/testmybatis/test/1/3 --currentPage从1开始，不是从0开始
 * @author LZG
 * @date 2019/4/17
 */
@RestController
@RequestMapping
public class ProjectDataSourceController {

    @Autowired
    private ProjectDataSourceService projectDataSourceService;

    @RequestMapping("/test/{currentPage}/{pageSize}")
    public InfoCoinResponse getPageProjectDataSource(@PathVariable int currentPage, @PathVariable int pageSize) {
        List<ProjectDataSource> pageProjectDataSource = projectDataSourceService.getPageProjectDataSource(currentPage, pageSize);
        return InfoCoinResponse.ok(pageProjectDataSource);
    }

}