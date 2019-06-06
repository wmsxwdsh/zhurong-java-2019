/**   
 * @Title: CodeGeneratorServiceImpl.java
 * @Package: com.essence.edop.generator.service.impl
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.generator.service.impl;

import com.zhurong.db.persistence.domain.ProjectDataSource;
import com.zhurong.generator.config.GenerateConfig;
import com.zhurong.generator.domain.MapperXml;
import com.zhurong.generator.domain.Model;
import com.zhurong.generator.domain.Table;
import com.zhurong.generator.service.CodeGeneratorService;
import com.zhurong.generator.support.GenerateFactory;
import com.zhurong.generator.util.DbMetaDataUtil;
import com.zhurong.generator.util.GeneratorUtil;
import com.zhurong.utils.date.DateUtil;
import java.util.Date;
import org.springframework.stereotype.Service;

/**
 * @description: 
 * @author LZG
 * @date 2019/3/28
 */
@Service
public class CodeGeneratorServiceImpl implements CodeGeneratorService {

    /**
     * @Description:
     * @param projectDataSource
     * @param tableNameArr
     * @return void
     * @author LZG
     * @date 2019/6/4
     */
    @Override
    public void handle(ProjectDataSource projectDataSource, String[] tableNameArr) throws Exception {

        for(String tableName : tableNameArr) {
            //类或或文件名
            String clazzName = GeneratorUtil.toUpperCase(tableName);
            //String clazzName = GeneratorUtil.toUpperCase(tableName) + "Domain";

            Table table = DbMetaDataUtil.getTable(tableName, projectDataSource);

            //1、生成domain
            Model model = new Model();
            model.setclazzName(clazzName);
            model.setPackageName(GenerateConfig.PKG_DOMAIN);
            model.setClazzComment(tableName + " Domain");
            model.setColumnList(table.getColumnList());
            model.setClazzAuthor(GenerateConfig.GEN_AUTHOR);
            model.setClazzDate(DateUtil.dateToString(new Date(), DateUtil.FORMAT_SLASH_YYYYMMDD));

            GenerateFactory.createModel().generateFile(model);

            //2、生成mapperXml
            MapperXml mapperXml = new MapperXml();
            mapperXml.setTableName(tableName);
            mapperXml.setColumnList(table.getColumnList());

            mapperXml.setClazzName(clazzName);
            mapperXml.setFileName(clazzName);
            mapperXml.setPackageName(GenerateConfig.PKG_MAPPER);
            mapperXml.setClazzPackageName(GenerateConfig.PKG_DOMAIN);

            GenerateFactory.createMapperXml().generateFile(mapperXml);

            //3、生成domainExample
            GenerateFactory.createModelExample().generateFile(model);

            //4、生成MapperJava
            GenerateFactory.createMapperJava().generateFile(mapperXml);

            //5、生成service

            //6、生成controller（正式开发这步基本省略）


        }

    }

}