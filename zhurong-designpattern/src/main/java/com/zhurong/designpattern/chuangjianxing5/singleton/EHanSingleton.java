/**   
 * @Title: EHanSingleton.java
 * @Package: com.zhurong.designpattern.chuangjianxing5.singleton
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.designpattern.chuangjianxing5.singleton;

/**
 * @description: 饿汉单例 --以空间换时间（不管你用不用，先建出来）
 * @author LZG
 * @date 2019/3/18
 */
public class EHanSingleton {

    private static EHanSingleton eHanSingleton = new EHanSingleton();

    public static EHanSingleton getInstance() {
        return eHanSingleton;
    }

}