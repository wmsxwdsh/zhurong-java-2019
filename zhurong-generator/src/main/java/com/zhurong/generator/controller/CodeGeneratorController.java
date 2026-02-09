package com.zhurong.generator.controller;

import com.zhurong.db.persistence.domain.ProjectDataSource;
import com.zhurong.generator.config.GenerateConfig;
import com.zhurong.generator.service.CodeGeneratorService;
import com.zhurong.generator.service.DataSourceService;
import com.zhurong.utils.response.edop.EdopResponse;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodeGeneratorController {

    @Autowired
    private DataSourceService dataSourceService;

    @Autowired
    private CodeGeneratorService codeGeneratorService;

    /**
     * 生成代码
     */
    @RequestMapping(value = "/codeGen", method = RequestMethod.GET)
    public EdopResponse handle() throws Exception {
        String dataSourceId = GenerateConfig.DATA_SOURCE_ID;
        String[] tableNameArr = GenerateConfig.TABLE_NAME_ARR;

        ProjectDataSource dataSource = dataSourceService.getDataSourceById(dataSourceId);
        codeGeneratorService.handle(dataSource, tableNameArr);

        return EdopResponse.ok("代码生成完毕, Good Luck !");
    }

    /**
     * 读取生成文件的代码，给前端做展示
     */
    private String readFileToString(String filePath) {
        String content = null;
        try {
            content = FileUtils.readFileToString(new File(filePath), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

}