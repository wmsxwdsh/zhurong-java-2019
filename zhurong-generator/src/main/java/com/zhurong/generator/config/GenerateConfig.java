/**
 * @Title: GenerateConfig.java
 * @Package: com.essence.edop.generator.config
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.generator.config;

/**
 * @description: 全局配置
 * @author LZG
 * @date 2019/3/27
 */
public class GenerateConfig {

    //-- 无需修改start ------------

    /** 文件作者名字 */
    public final static String GEN_AUTHOR = "LZG Robot";

    /** java文件的后缀 */
    public static final String JAVA_SUFFIX = ".java";

    /** xxxMapper.xml文件的后缀 */
    public static final String MAPPER_XML_SUFFIX = ".xml";

    /** 实体包后缀 */
    public final static String MAPPER_MODEL_SUFFIX = ".model";

    //-- 无需修改end --------------------

    /** 数据源id */
    public final static String DATA_SOURCE_ID = "2955773608684017341465197888987"; //mysql zhurong

    /** 要自动生成代码的表名数组*/
    public final static String[] TABLE_NAME_ARR = {"tb_city_info", "tb_dictionary"};

    /** 主目录路径（项目名）, 用idea的话src后面的不用改 */
    public final static String SRC_PATH = "zhurong-generator\\src\\main\\java\\";

    // 子modul的示例
    //public final static String SRC_PATH = "edop-persistence\\edop-persistence-mybatis\\src\\main\\java\\";

    /** domain存放的路径*/
    public static final String PKG_DOMAIN = "com.zhurong.generator.persistence.mybatis.domain";

    /** mapper存放的路径*/
    public static final String PKG_MAPPER = "com.zhurong.generator.persistence.mybatis.mapper.generic";





}