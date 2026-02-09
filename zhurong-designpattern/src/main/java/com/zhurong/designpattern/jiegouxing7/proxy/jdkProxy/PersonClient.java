package com.zhurong.designpattern.jiegouxing7.proxy.jdkProxy;

import com.zhurong.designpattern.jiegouxing7.proxy.ChuZuFang;
import com.zhurong.designpattern.jiegouxing7.proxy.FangDong;

public class PersonClient {

    public static void main(String[] args) {
        ChuZuFang chuZuFang = (ChuZuFang) new LianJiaJDKProxy().getInstance(new FangDong());
        chuZuFang.chuZu();
    }

}