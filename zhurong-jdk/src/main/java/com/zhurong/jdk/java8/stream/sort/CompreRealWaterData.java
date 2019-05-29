/**   
 * @Title: CompreRealWaterData.java
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