/**   
 * @Title: DateUnit.java
 * @Package: com.zhurong.utils.date
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.date;

/**
 * @description: 日期时间单位，每个单位都以毫秒为基数
 * @author LZG
 * @date 2018/8/27
 */
public enum DateUnit {

    /*一毫秒*/
    MS(1),

    /*一秒的毫秒数*/
    SECOND(1000),

    /*一分钟的毫秒数*/
    MINUTE(SECOND.getMillis() * 60),

    /*一小时的毫秒数*/
    HOUR(MINUTE.getMillis() * 60),

    /*一天的毫秒数*/
    DAY(HOUR.getMillis() * 24),

    /*一周的毫秒数*/
    WEEK(DAY.getMillis() * 7);

    private long millis;

    DateUnit(long millis){
        this.millis = millis;
    }

    /**
     * @Description: 单位对应的毫秒数
     * @return long
     * @author LZG
     * @date 2018/8/27
     */
    public long getMillis(){
        return this.millis;
    }

}