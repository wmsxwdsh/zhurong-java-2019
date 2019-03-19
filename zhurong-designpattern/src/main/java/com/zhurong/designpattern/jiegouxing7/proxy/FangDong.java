/**   
 * @Title: FangDong.java
 * @Package: com.zhurong.designpattern.jiegouxing7.proxy.staticProxy
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.designpattern.jiegouxing7.proxy;

/**
 * @description: 房东
 * @author LZG
 * @date 2019/3/19
 */
public class FangDong implements ChuZuFang {

    public void chuZu() {
        System.out.println("房东出租房子");
    }

}