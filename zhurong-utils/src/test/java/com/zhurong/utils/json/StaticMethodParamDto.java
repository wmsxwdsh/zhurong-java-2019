/**   
 * @Title: StaticMethodParamDto.java
 * @Package: com.zhurong.utils.json
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.utils.json;

/**
 * @description: GIS服务方法参数的实体类
 * @author LZG
 * @date 2019/7/10
 */
public class StaticMethodParamDto {

    /**
     * 参数名称
     */
    private String paramName;
    /**
     * 使用的流程项排序值
     */
    private Integer useItemIndexOutput;
    /**
     * 使用的参数名称（上一步的输出参数）
     */
    private String useItemIndexParamName;
    /**
     * 参数类型(in输入 out输出)
     */
    private String paramType;
    /**
     * 输出结果文件名称
     */
    private String outFileName;
    /**
     * 后缀名
     */
    private String fileSuffix;

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public Integer getUseItemIndexOutput() {
        return useItemIndexOutput;
    }

    public void setUseItemIndexOutput(Integer useItemIndexOutput) {
        this.useItemIndexOutput = useItemIndexOutput;
    }

    public String getUseItemIndexParamName() {
        return useItemIndexParamName;
    }

    public void setUseItemIndexParamName(String useItemIndexParamName) {
        this.useItemIndexParamName = useItemIndexParamName;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public String getOutFileName() {
        return outFileName;
    }

    public void setOutFileName(String outFileName) {
        this.outFileName = outFileName;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    @Override
    public String toString() {
        return "StaticMethodParamDto{" +
            "paramName='" + paramName + '\'' +
            ", useItemIndexOutput=" + useItemIndexOutput +
            ", useItemIndexParamName='" + useItemIndexParamName + '\'' +
            ", paramType='" + paramType + '\'' +
            ", outFileName='" + outFileName + '\'' +
            ", fileSuffix='" + fileSuffix + '\'' +
            '}';
    }
}