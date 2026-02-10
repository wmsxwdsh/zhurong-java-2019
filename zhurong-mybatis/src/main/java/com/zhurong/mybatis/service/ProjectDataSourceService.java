package com.zhurong.mybatis.service;

import com.zhurong.db.persistence.domain.ProjectDataSource;
import java.util.List;

public interface ProjectDataSourceService {

    /**
     * 分页查询数据源数据
     * @param currentPage 第X页
     * @param pageSize 条数
     */
    public List<ProjectDataSource> getPageProjectDataSource(int currentPage, int pageSize);

}
