package com.zhurong.jdk.java8.stream.sort;

public class CompreRealWaterData {

    private String areaName; //区域名称

    private int waterNum; //实际用水量

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public int getWaterNum() {
        return waterNum;
    }

    public void setWaterNum(int waterNum) {
        this.waterNum = waterNum;
    }

    @Override
    public String toString() {
        return "CompreRealWaterData{" +
            "areaName='" + areaName + '\'' +
            ", waterNum=" + waterNum +
            '}';
    }

}