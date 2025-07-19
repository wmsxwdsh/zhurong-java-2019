/**   
 * @Title: GenerateModelExample.java
 * @Package: com.zhurong.generator.generate
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.generator.generate;

import com.zhurong.generator.config.GenerateConfig;
import com.zhurong.generator.domain.Model;
import com.zhurong.generator.support.IGenerate;
import com.zhurong.generator.util.FreeMarkerTemplateUtil;
import com.zhurong.utils.common.PathUtil;
import com.zhurong.utils.general.StringUtil;
import java.io.File;

/**
 * @description: 
 * @author LZG
 * @date 2019/6/5
 */
public class GenerateModelExample implements IGenerate<Model> {

    /**
     * @Description: 生成文件
     * @param model
     * @return String 生成文件的全路径
     * @author LZG
     * @date 2019/3/27
     */
    @Override
    public String generateFile(Model model) throws Exception {
        String path = PathUtil.getProjectPath() + GenerateConfig.SRC_PATH
            + StringUtil.package2path(model.getPackageName() + StringUtil.DOT);

        String templateName = "ModelExample.ftl";

        File pat = new File(path);
        if (!pat.exists()) {
            pat.mkdirs();
        }

        String filePath = path + model.getclazzName() + "Example" + GenerateConfig.JAVA_SUFFIX;
        File file = new File(filePath);

        FreeMarkerTemplateUtil.generateFile(templateName, file, model);

        return filePath;
    }

}