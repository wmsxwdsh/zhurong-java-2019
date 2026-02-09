package com.zhurong.designpattern.jiegouxing7.proxy.cglibProxy;

import com.zhurong.designpattern.jiegouxing7.proxy.ChuZuFang;
import com.zhurong.designpattern.jiegouxing7.proxy.FangDong;

public class PersonClient {

    public static void main(String[] args) {

        ChuZuFang chuZuFang = (ChuZuFang)new LianJiaCglibProxy().getInstance(new FangDong());
        chuZuFang.chuZu();
    }
}