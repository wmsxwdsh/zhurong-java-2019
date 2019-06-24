/**   
 * @Title: SortCondition.java
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