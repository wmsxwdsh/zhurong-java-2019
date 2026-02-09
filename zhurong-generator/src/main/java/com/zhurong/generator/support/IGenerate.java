package com.zhurong.generator.support;

/**
 * 生成相关的泛型接口
 */
@FunctionalInterface
public interface IGenerate<T> {

    /**
     * 生成文件
     * @param t
     * @return String 生成文件的全路径
     */
    String generateFile(T t) throws Exception;
}