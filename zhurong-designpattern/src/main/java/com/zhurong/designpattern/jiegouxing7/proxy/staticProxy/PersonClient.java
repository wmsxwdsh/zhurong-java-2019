/**
 * @Title: PersonClient.java
 * @Package: com.zhurong.designpattern.jiegouxing7.proxy.staticProxy
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.designpattern.jiegouxing7.proxy.staticProxy;

import com.zhurong.designpattern.jiegouxing7.proxy.FangDong;

/**
 * @description: 要租房的刚毕业的大学生
 *          --缺点：代理类的每一个接口对应一个委托对象，如果委托对象非常多，那么静态代理就不合适了。
 * @author LZG
 * @date 2019/3/19
 */
public class PersonClient {

    public static void main(String[] args) {

        //链家就是代理类proxy
        LianJiaProxy lianJia = new LianJiaProxy(new FangDong());
        lianJia.chuZu();

    }
}