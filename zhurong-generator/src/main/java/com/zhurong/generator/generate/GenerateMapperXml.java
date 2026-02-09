package com.zhurong.generator.generate;

import com.zhurong.generator.config.GenerateConfig;
import com.zhurong.generator.domain.MapperXml;
import com.zhurong.generator.support.IGenerate;
import com.zhurong.generator.util.FreeMarkerTemplateUtil;
import com.zhurong.utils.common.PathUtil;
import com.zhurong.utils.common.StringUtil;

import java.io.File;

/**
 * mapper.xml
 * 2019/3/27
 */
public class GenerateMapperXml implements IGenerate<MapperXml> {

    /**
     * 生成文件
     * @param mapperXml
     * @return String 生成文件的全路径
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