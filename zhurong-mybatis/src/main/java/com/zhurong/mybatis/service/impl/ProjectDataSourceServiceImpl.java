/**
 * @Title: ProjectDataSourceServiceImpl.java
 * @Package: com.zhurong.mybatis.service.impl
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.mybatis.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhurong.db.persistence.domain.ProjectDataSource;
import com.zhurong.db.persistence.domain.ProjectDataSourceExample;
import com.zhurong.db.persistence.domain.ProjectDataSourceExample.Criteria;
import com.zhurong.db.persistence.mapper.generic.ProjectDataSourceMapper;
import com.zhurong.mybatis.service.ProjectDataSourceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author LZG
 * @date 2019/4/17
 */
@Service
public class ProjectDataSourceServiceImpl implements ProjectDataSourceService {

    @Autowired
    private ProjectDataSourceMapper projectDataSourceMapper;

    /**
     * @Description: 分页查询数据源数据
     * @param currentPage 第X页
     * @param pageSize 条数
     * @return java.util.List<com.zhurong.db.persistence.domain.ProjectDataSource>
     * @author LZG
     * @date 2019/4/17
     */
    @Override
    public List<ProjectDataSource> getPageProjectDataSource(int currentPage, int pageSize) {
        //Example为null，是查询所有数据
        List<ProjectDataSource> list1 = projectDataSourceMapper.selectByExample(null);

        currentPage = currentPage < 1 ? 1 : currentPage;
        pageSize = pageSize < 1 ? 5 : pageSize;

        Page<ProjectDataSource> page = PageHelper.startPage(currentPage, pageSize); //2和pageSize

        //list2在这里是分页后的数据List，实际开发请把List<ProjectDataSource> list2删除
        //List<ProjectDataSource> list2 = projectDataSourceMapper.selectByExample(null);

        ProjectDataSourceExample example = new ProjectDataSourceExample();
        Criteria criteria = example.createCriteria();
        criteria.andEnvTypeEqualTo("dev");
        example.setOrderByClause("db_user asc"); //asc升序，desc降序

        //list3就是模糊查询分页
        List<ProjectDataSource> list3 = projectDataSourceMapper.selectByExample(example);

        //实际开发返回给前端的一般是pageInfo
        PageInfo<ProjectDataSource> pageInfo = page.toPageInfo();

        List<ProjectDataSource> testlist = pageInfo.getList();
        return testlist;
    }

}