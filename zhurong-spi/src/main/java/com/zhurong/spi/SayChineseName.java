/**
 * @Title: SayChineseName.java
 * @Package: com.zhurong.spi
 * @author LZG, liuzhongguo@cdvcloud.com
 * Copyright (c) 2020 https://www.yunshicloud.com
 */
package com.zhurong.spi;

/**
 * @description:
 * @author LZG
 * @date 2020年05月26日
 */
public class SayChineseName implements SayName {

    @Override
    public void say() {
        System.out.println("刘德华");
    }
}