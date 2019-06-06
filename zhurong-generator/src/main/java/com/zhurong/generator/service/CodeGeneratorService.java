/**
 * @Title: CodeGeneratorService.java
 * @Package: com.essence.edop.generator.service
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.generator.service;


import com.zhurong.db.persistence.domain.ProjectDataSource;

/**
 * @description:
 * @author LZG
 * @date 2019/3/28
 */
public interface CodeGeneratorService {

    /**
     * @Description: 代码生成
     * @param projectDataSource
     * @param tableNameArr
     * @return void
     * @author LZG
     * @date 2019/6/4
     */
    void handle(ProjectDataSource projectDataSource, String[] tableNameArr) throws Exception;

}