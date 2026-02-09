package com.zhurong.jdk.java8.stream.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class Md5SaltTestStreamSort {

    @Test
    public void test1() {
        //造数据
        List<CompreTotalData> list = new ArrayList<>();
        CompreTotalData compreTotalData1 = new CompreTotalData();
        CompreTotalData compreTotalData2 = new CompreTotalData();
        CompreTotalData compreTotalData3 = new CompreTotalData();
        CompreTotalData compreTotalData4 = new CompreTotalData();

        CompreRealWaterData compreRealWaterData1 = new CompreRealWaterData();
        compreRealWaterData1.setAreaName("昌平");
        compreRealWaterData1.setWaterNum(30);

        CompreRealWaterData compreRealWaterData2 = new CompreRealWaterData();
        compreRealWaterData2.setAreaName("海淀");
        compreRealWaterData2.setWaterNum(50);

        CompreRealWaterData compreRealWaterData3 = new CompreRealWaterData();
        compreRealWaterData3.setAreaName("朝阳");
        compreRealWaterData3.setWaterNum(20);

        CompreRealWaterData compreRealWaterData4 = new CompreRealWaterData();
        compreRealWaterData4.setAreaName("大兴");
        compreRealWaterData4.setWaterNum(35);

        ComprePlotData comprePlotData1 = new ComprePlotData();
        comprePlotData1.setDatianArea(198);
        comprePlotData1.setTotalArea(216);

        ComprePlotData comprePlotData2 = new ComprePlotData();
        comprePlotData2.setDatianArea(355);
        comprePlotData2.setTotalArea(463);

        ComprePlotData comprePlotData3 = new ComprePlotData();
        comprePlotData3.setDatianArea(269);
        comprePlotData3.setTotalArea(302);

        ComprePlotData comprePlotData4 = new ComprePlotData();
        comprePlotData4.setDatianArea(118);
        comprePlotData4.setTotalArea(133);

        compreTotalData1.setCurrWaterData(compreRealWaterData1);
        compreTotalData1.setPlotData(comprePlotData1);

        compreTotalData2.setCurrWaterData(compreRealWaterData2);
        compreTotalData2.setPlotData(comprePlotData2);

        compreTotalData3.setCurrWaterData(compreRealWaterData3);
        compreTotalData3.setPlotData(comprePlotData3);

        compreTotalData4.setCurrWaterData(compreRealWaterData4);
        compreTotalData4.setPlotData(comprePlotData4);

        list.add(compreTotalData1);
        list.add(compreTotalData2);
        list.add(compreTotalData3);
        list.add(compreTotalData4);

        //正文开始-------------------
        list = list.stream().sorted(Comparator.comparing((CompreTotalData c) -> c.getCurrWaterData().getWaterNum()).reversed())
                .collect(Collectors.toList());

        for (CompreTotalData element : list) {
            System.out.println(element);
        }

    }

}