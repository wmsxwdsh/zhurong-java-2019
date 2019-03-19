/**   
 * @Title: LuZhiShen.java
 * @Package: com.zhurong.designpattern.jiegouxing7.adapter
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.designpattern.jiegouxing7.adapter;

/**
 * @description: 鲁志深
 * @author LZG
 * @date 2019/3/19
 */
public class LuZhiShen extends TianXing {

    @Override
    public void xiWu() {
        System.out.println("拳打镇关西");
        System.out.println("大闹五台山");
        System.out.println("大闹桃花村");
        System.out.println("火烧瓦官寺");
        System.out.println("倒拔垂杨柳");
    }

    @Override
    public String getName() {
        return "鲁志深";
    }
}