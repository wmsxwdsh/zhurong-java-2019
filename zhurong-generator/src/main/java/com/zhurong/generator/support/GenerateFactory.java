/**   
 * @Title: GenerateFactory.java
 * @Package: com.essence.edop.generator.support
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.generator.support;


import com.zhurong.generator.domain.MapperXml;
import com.zhurong.generator.domain.Model;
import com.zhurong.generator.generate.GenerateMapperJava;
import com.zhurong.generator.generate.GenerateMapperXml;
import com.zhurong.generator.generate.GenerateModel;
import com.zhurong.generator.generate.GenerateModelExample;

/**
 * @description: 代码生成器工厂类
 * @author LZG
 * @date 2019/3/27
 */
public class GenerateFactory {

    //生产domain
    public static IGenerate<Model> createModel() {
        return new GenerateModel();
    }

    //生产mapper.xml
    public static IGenerate<MapperXml> createMapperXml() {
        return new GenerateMapperXml();
    }

    //生产domainExample
    public static IGenerate<Model> createModelExample() {
        return new GenerateModelExample();
    }

    //生产mapper.java
    public static IGenerate<MapperXml> createMapperJava() {
        return new GenerateMapperJava();
    }

}