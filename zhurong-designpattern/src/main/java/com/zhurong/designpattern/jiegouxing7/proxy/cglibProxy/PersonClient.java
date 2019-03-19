/**   
 * @Title: PersonClient.java
 * @Package: com.zhurong.designpattern.jiegouxing7.proxy.cglibProxy
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.designpattern.jiegouxing7.proxy.cglibProxy;

import com.zhurong.designpattern.jiegouxing7.proxy.ChuZuFang;
import com.zhurong.designpattern.jiegouxing7.proxy.FangDong;

/**
 * @description: 
 * @author LZG
 * @date 2019/3/19
 */
public class PersonClient {

    public static void main(String[] args) {

        ChuZuFang chuZuFang = (ChuZuFang)new LianJiaCglibProxy().getInstance(new FangDong());
        chuZuFang.chuZu();
    }
}