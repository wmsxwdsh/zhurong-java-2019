/**
 * @Title: GenerateMapperXml.java
 * @Package: com.essence.edop.generator.generate
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.generator.generate;

import com.zhurong.generator.config.GenerateConfig;
import com.zhurong.generator.domain.MapperXml;
import com.zhurong.generator.support.IGenerate;
import com.zhurong.generator.util.FreeMarkerTemplateUtil;
import com.zhurong.utils.common.PathUtil;
import com.zhurong.utils.general.StringUtil;
import java.io.File;

/**
 * @description: mapper.xml
 * @author LZG
 * @date 2019/3/27
 */
public class GenerateMapperXml implements IGenerate<MapperXml> {

    /**
     * @Description: 生成文件
     * @param mapperXml
     * @return String 生成文件的全路径
     * @author LZG
     * @date 2019/3/27
     */
    @Override
    public String generateFile(MapperXml mapperXml) throws Exception {
        String path = PathUtil.getProjectPath() + GenerateConfig.SRC_PATH
            + StringUtil.package2path(mapperXml.getPackageName() +  StringUtil.DOT);

        String templateName = "MapperXml.ftl";

        File pat = new File(path);
        if (!pat.exists()) {
            pat.mkdirs();
        }

        String filePath = path + mapperXml.getFileName() + "Mapper" + GenerateConfig.MAPPER_XML_SUFFIX;
        File file = new File(filePath);

        FreeMarkerTemplateUtil.generateFile(templateName, file, mapperXml);

        return filePath;
    }

}