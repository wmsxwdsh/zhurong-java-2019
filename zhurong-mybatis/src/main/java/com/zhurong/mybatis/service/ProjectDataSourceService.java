/**   
 * @Title: ProjectDataSourceService.java
 * @Package: com.zhurong.mybatis.service
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京中数合一科技有限公司
 */
package com.zhurong.mybatis.service;

import com.zhurong.db.persistence.domain.ProjectDataSource;
import java.util.List;

/**
 * @description: 
 * @author LZG
 * @date 2019/4/17
 */
public interface ProjectDataSourceService {

    /**
     * @Description: 分页查询数据源数据
     * @param currentPage 第X页
     * @param pageSize 条数
     * @return java.util.List<com.zhurong.db.persistence.domain.ProjectDataSource>
     * @author LZG
     * @date 2019/4/17
     */
    public List<ProjectDataSource> getPageProjectDataSource(int currentPage, int pageSize);

}
