/**
 * @Title: ComprePlotData.java
 * @Package: com.zhurong.jdk.java8.stream.sort
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.jdk.java8.stream.sort;

/**
 * @description:
 * @author LZG
 * @date 2019/5/29
 */
public class ComprePlotData {

    //大田面积
    private int datianArea;

    //总面积
    private int totalArea;

    public int getDatianArea() {
        return datianArea;
    }

    public void setDatianArea(int datianArea) {
        this.datianArea = datianArea;
    }

    public int getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(int totalArea) {
        this.totalArea = totalArea;
    }

    @Override
    public String toString() {
        return "ComprePlotData{" +
            "datianArea=" + datianArea +
            ", totalArea=" + totalArea +
            '}';
    }

}