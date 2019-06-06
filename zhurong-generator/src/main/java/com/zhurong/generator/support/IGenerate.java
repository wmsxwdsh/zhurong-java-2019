/**   
 * @Title: IGenerate.java
 * @Package: com.essence.edop.generator.support
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.generator.support;

/**
 * @description: 生成相关的泛型接口
 * @author LZG
 * @date 2019/3/27
 */
@FunctionalInterface
public interface IGenerate<T> {

    /**
     * @Description: 生成文件
     * @param t
     * @return String 生成文件的全路径
     * @author LZG
     * @date 2019/3/27
     */
    String generateFile(T t) throws Exception;
}