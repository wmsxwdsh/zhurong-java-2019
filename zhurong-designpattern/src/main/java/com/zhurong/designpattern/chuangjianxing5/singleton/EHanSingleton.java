package com.zhurong.designpattern.chuangjianxing5.singleton;

/**
 * 饿汉单例 --以空间换时间（不管你用不用，先建出来）
 * 2019/3/18
 */
public class EHanSingleton {

    private static EHanSingleton eHanSingleton = new EHanSingleton();

    public static EHanSingleton getInstance() {
        return eHanSingleton;
    }

}