/**
 * @Title: TestDateUtil.java
 * @Package: com.zhurong.utils.date
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.date;

import java.util.Date;
import java.util.List;
import org.junit.Test;

/**
 * @description: DateUtil测试类
 * @author LZG
 * @date 2018/8/27
 */
public class Md5SaltTestDateUtil {

    @Test
    public void testAddDays() {
        Date date4 = DateUtil.stringToDate("2018-08-25 18:34:51", DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);
        System.out.println(DateUtil.dateToString(DateUtil.addDays(date4, 20), DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));
    }

    @Test
    public void testGetDifferentNum() {
        Date date1 = DateUtil.stringToDate("2018-08-25 15:05:00", DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);
        Date date2 = DateUtil.stringToDate("2018-08-25 15:05:49", DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);
        System.out.println(DateUtil.getDifferentNum(date1, date2, 0));

        Date date3 = DateUtil.stringToDate("2018-08-25 18:34:51", DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);
        System.out.println(DateUtil.getDifferentNum(date2, date3, 2));
    }

    @Test
    public void test() {

        Date before = DateUtil.stringToDate("2018-05-11 12:45:22", DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);
        Date after = DateUtil.stringToDate("2018-05-15 20:10:55", DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);
        System.out.println(DateUtil.getDistanceTwoDate(before, after));

        System.out.println(DateUtil.getYear(DateUtil.stringToDate("2013-05-15 20:10:55", DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS)));
        System.out.println(DateUtil.getMonth(new Date()));
        System.out.println(DateUtil.getDayOfMonth(new Date()));
    }

    // Date、String相互转换
    @Test
    public void testDateStringConvert() {
        System.out.println(DateUtil.dateToString(DateUtil.getYesterday(), DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));
        System.out.println(DateUtil.dateToString(DateUtil.getTomorrow(), DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));

        Date before = DateUtil.stringToDate("2018-05-11 12:45:22", DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);
        Date after = DateUtil.stringToDate("2018-05-15 20:10:55", DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);

        Date d1 = DateUtil.stringToDate("2019-06-24", DateUtil.FORMAT_YYYY_MM_DD);
    }

    @Test
    public void testGetNow() {
        System.out.println(DateUtil.getNow(DateUtil.FORMAT_YYYY_MM_DD));
        System.out.println(DateUtil.getNow(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));
    }

    @Test
    public void testGetBetweenDate() {
        String startTime = "2019-07-20";
        String endTime = "2019-08-05";
        List<String> betweenDateStrList = DateUtil.getBetweenDate(startTime, endTime);
        for(String s : betweenDateStrList) {
            System.out.println(s);
        }


    }

}