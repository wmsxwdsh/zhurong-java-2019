package com.zhurong.generator.generate;

import com.zhurong.generator.config.GenerateConfig;
import com.zhurong.generator.domain.Model;
import com.zhurong.generator.support.IGenerate;
import com.zhurong.generator.util.FreeMarkerTemplateUtil;
import com.zhurong.utils.common.PathUtil;
import com.zhurong.utils.common.StringUtil;

import java.io.File;

public class GenerateModel implements IGenerate<Model> {

    /**
     * 生成文件
     * @param model
     * @return String 生成文件的全路径
     */
    @Override
    public String generateFile(Model model) throws Exception {
        String path = PathUtil.getProjectPath() + GenerateConfig.SRC_PATH
            + StringUtil.package2path(model.getPackageName() + StringUtil.DOT);

        String templateName = "Model.ftl";

        File pat = new File(path);
        if (!pat.exists()) {
            pat.mkdirs();
        }

        String filePath = path + model.getclazzName() + GenerateConfig.JAVA_SUFFIX;
        File file = new File(filePath);

        FreeMarkerTemplateUtil.generateFile(templateName, file, model);

        return filePath;
    }

}