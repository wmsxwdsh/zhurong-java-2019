package com.zhurong.mybatis.pagehelperplus;

public class SearchCondition {

    //字段名称
    private String property;

    //匹配符
    private String mate; //like =

    //字段模糊值
    private String value;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getMate() {
        return mate;
    }

    public void setMate(String mate) {
        this.mate = mate;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}