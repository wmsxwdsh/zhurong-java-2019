package com.zhurong.designpattern.chuangjianxing5.builder;

/**
 * 具体的产品---房子
 * 2019/3/20
 */
public class Product {

    private String basic;//地基

    private String wall;//墙

    private String roofed;//楼顶

    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic = basic;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getRoofed() {
        return roofed;
    }

    public void setRoofed(String roofed) {
        this.roofed = roofed;
    }
    
}