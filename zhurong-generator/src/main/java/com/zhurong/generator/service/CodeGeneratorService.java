package com.zhurong.generator.service;

import com.zhurong.db.persistence.domain.ProjectDataSource;

public interface CodeGeneratorService {

    /**
     * 代码生成
     */
    void handle(ProjectDataSource projectDataSource, String[] tableNameArr) throws Exception;

}