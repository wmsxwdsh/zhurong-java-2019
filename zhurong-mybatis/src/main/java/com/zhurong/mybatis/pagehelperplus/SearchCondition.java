/**   
 * @Title: SearchCondition.java
 * @Package: com.zhurong.mybatis.page
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.mybatis.pagehelperplus;

/**
 * @description: 
 * @author LZG
 * @date 2019/6/21
 */
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