/**
 * @Title: FreeMarkerTemplateUtil.java
 * @Package: com.essence.edop.generator.util
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.generator.util;

import com.zhurong.generator.domain.BaseDomain;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * @description: 模板工具类
 * @author LZG
 * @date 2019/3/27
 */
public class FreeMarkerTemplateUtil {

    private FreeMarkerTemplateUtil() {
    }

    private static final Configuration CONFIGURATION = new Configuration();

    static {
        try {
            //这里比较重要，用来指定加载模板所在的路径
            CONFIGURATION.setClassForTemplateLoading(FreeMarkerTemplateUtil.class, "/templates");
            CONFIGURATION.setDefaultEncoding("UTF-8");
            CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            CONFIGURATION.setCacheStorage(new freemarker.cache.MruCacheStorage(20, 250));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 获得模板
     * @param templateName
     * @return freemarker.template.Template
     * @author LZG
     * @date 2019/3/27
     */
    public static Template getTemplate(String templateName) throws IOException {
        try {
            return CONFIGURATION.getTemplate(templateName);
        } catch (IOException e) {
            throw e;
        }
    }

    /**
     * @Description: 清除freemarker缓存
     * @return void
     * @author LZG
     * @date 2019/3/27
     */
    public static void clearCache() {
        CONFIGURATION.clearTemplateCache();
    }

    /**
     * @Description: 通过模板生成可以使用的文件
     * @param templateName
     * @param file
     * @param entity
     * @return void
     * @author LZG
     * @date 2019/3/27
     */
    public static void generateFile(final String templateName, File file, BaseDomain domain) throws Exception {
        Template template = getTemplate(templateName);
        FileOutputStream fos = new FileOutputStream(file);
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"), 10240);
        template.process(domain, out);

        if (null != out) {
            out.close();
        }
        if (null != fos) {
            fos.close();
        }
        clearCache();
    }

}