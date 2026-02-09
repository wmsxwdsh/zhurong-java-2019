package com.zhurong.jdk.java8.stream.sort;

public class CompreTotalData {

    //区用水统一
    private CompreRealWaterData currWaterData;

    //全区地块信息数据
    private ComprePlotData plotData;

    public CompreRealWaterData getCurrWaterData() {
        return currWaterData;
    }

    public void setCurrWaterData(CompreRealWaterData currWaterData) {
        this.currWaterData = currWaterData;
    }

    public ComprePlotData getPlotData() {
        return plotData;
    }

    public void setPlotData(ComprePlotData plotData) {
        this.plotData = plotData;
    }

    @Override
    public String toString() {
        return "CompreTotalData{" +
            "currWaterData=" + currWaterData +
            ", plotData=" + plotData +
            '}';
    }

}