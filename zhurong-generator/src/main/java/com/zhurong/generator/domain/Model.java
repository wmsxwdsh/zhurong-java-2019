package com.zhurong.generator.domain;

import java.util.List;

public class Model extends BaseDomain {

    //类名
    private String clazzName;

    //包名
    private String packageName;

    //属性列表
    private List<Column> columnList = null;

    public Model() {
        super();
    }

    public Model(String clazzName, String packageName, List<Column> columnList) {
        super();
        this.clazzName = clazzName;
        this.packageName = packageName;
        this.columnList = columnList;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getclazzName() {
        return clazzName;
    }

    public void setclazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public List<Column> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<Column> columnList) {
        this.columnList = columnList;
    }


    @Override
    public String toString() {
        return "Model{" +
            "clazzName='" + clazzName + '\'' +
            ", packageName='" + packageName + '\'' +
            ", columnList=" + columnList +
            '}';
    }
}