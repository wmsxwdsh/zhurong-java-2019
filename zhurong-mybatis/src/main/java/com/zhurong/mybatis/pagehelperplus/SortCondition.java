package com.zhurong.mybatis.pagehelperplus;

public class SortCondition {

    //字段名称
    private String property;

    //升序or降序
    private String direction;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

}