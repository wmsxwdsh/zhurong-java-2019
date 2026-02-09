package com.zhurong.jdk.java8.stream.sort;

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