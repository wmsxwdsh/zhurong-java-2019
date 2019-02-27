/**   
 * @Title: FreemarkerUtil.java
 * @Package: com.zhurong.utils.freemarker
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import java.io.File;
import java.io.StringWriter;
import java.util.Map;

/**
 * @description: freemarker工具类
 *      freemarker依赖版本号2.3.23
 * @author LZG
 * @date 2018/8/27
 */
public class FreemarkerUtil {

    /**
     * @Description: 用dateMap填充freemarker模板
     * @param fltFile flt模板的名称
     * @param templatePath flt模板的位置
     * @param dateMap 数据
     * @return java.lang.String
     * @author LZG
     * @date 2018/8/27
     */
    public static String geneFileStr(String fltFile, String templatePath, Map<String, Object> dateMap){

        /**
         * 直接new Configuration()会提示deprecated(已过时)
         * 推荐带new Version的写法，此处版本号需要pom里freemarker的依赖版本一致
         */
        Configuration cfg = new Configuration(new Version("2.3.23"));

        try {
            cfg.setDirectoryForTemplateLoading(new File(templatePath));
            Template template = cfg.getTemplate(fltFile);

            StringWriter out = new StringWriter();

            template.process(dateMap, out);

            out.flush();
            out.close();

            return out.getBuffer().toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}