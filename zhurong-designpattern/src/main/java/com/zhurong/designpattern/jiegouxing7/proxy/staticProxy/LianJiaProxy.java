package com.zhurong.designpattern.jiegouxing7.proxy.staticProxy;

import com.zhurong.designpattern.jiegouxing7.proxy.ChuZuFang;
import com.zhurong.designpattern.jiegouxing7.proxy.FangDong;

/**
 * 链家，也就是 Proxy
 * 2019/3/19
 */
public class LianJiaProxy implements ChuZuFang {

    private FangDong fangDong;

    public LianJiaProxy(FangDong fangDong) {
        this.fangDong = fangDong;
    }

    @Override
    public void chuZu() {
        System.out.println("收点中介费");

        fangDong.chuZu();

        System.out.println("再收点服务费");
    }
}