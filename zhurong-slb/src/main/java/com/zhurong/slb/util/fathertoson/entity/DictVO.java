/**
 * @Title: DictVO.java
 * @Package: com.zhurong.slb.util.fathertoson.entity
 * @author LZG, liuzg@12366.com
 * Copyright (c) 2020 http://www.12366.com
 */
package com.zhurong.slb.util.fathertoson.entity;

/**
 * @description:
 * @author LZG
 * @date 2020年06月22日
 */
public class DictVO extends Dict {
    private static final long serialVersionUID = -39695256639303197L;

    private String categoryName;

    private int dictNo;

    private boolean isBlack;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getDictNo() {
        return dictNo;
    }

    public void setDictNo(int dictNo) {
        this.dictNo = dictNo;
    }

    public boolean isBlack() {
        return isBlack;
    }

    public void setBlack(boolean black) {
        isBlack = black;
    }

    @Override
    public String toString() {
        return "DictVO{" +
                "categoryName='" + categoryName + '\'' +
                ", dictNo=" + dictNo +
                ", isBlack=" + isBlack +
                "} " + super.toString();
    }

}