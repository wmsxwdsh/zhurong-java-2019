/**
 * @Title: MapperXml.java
 * @Package: com.essence.edop.generator.domain
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.generator.domain;

import java.util.List;

/**
 * @description:
 * @author LZG
 * @date 2019/3/27
 */
public class MapperXml extends BaseDomain {

    //类名
    private String clazzName;

    //包名（XML关联类的包名）
    private String clazzPackageName;

    //包名（XML的包名）
    private String packageName;

    //表名
    private String tableName;

    //xml文件名
    private String fileName;

    //字段名
    private List<Column> columnList = null;

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public String getClazzPackageName() {
        return clazzPackageName;
    }

    public void setClazzPackageName(String clazzPackageName) {
        this.clazzPackageName = clazzPackageName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<Column> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<Column> columnList) {
        this.columnList = columnList;
    }

}