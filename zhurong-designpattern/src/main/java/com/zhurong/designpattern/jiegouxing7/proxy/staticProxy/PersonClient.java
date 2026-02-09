package com.zhurong.designpattern.jiegouxing7.proxy.staticProxy;

import com.zhurong.designpattern.jiegouxing7.proxy.FangDong;

/**
 * 要租房的刚毕业的大学生
 * --缺点：代理类的每一个接口对应一个委托对象，如果委托对象非常多，那么静态代理就不合适了。
 * 2019/3/19
 */
public class PersonClient {

    public static void main(String[] args) {

        //链家就是代理类proxy
        LianJiaProxy lianJia = new LianJiaProxy(new FangDong());
        lianJia.chuZu();

    }
}