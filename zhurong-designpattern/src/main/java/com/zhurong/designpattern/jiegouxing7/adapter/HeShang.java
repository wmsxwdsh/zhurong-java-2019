/**
 * @Title: HeShang.java
 * @Package: com.zhurong.designpattern.jiegouxing7.adapter
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.designpattern.jiegouxing7.adapter;

/**
 * @description: 和尚
 * @author LZG
 * @date 2019/3/19
 */
public interface HeShang {

    //吃斋
    public void chiZhai();

    //念经
    public void nianJing();

    //打坐
    public void daZuo();

    //撞钟
    public void zhuangZhong();

    //习武
    public void xiWu();

    public String getName();
    
}