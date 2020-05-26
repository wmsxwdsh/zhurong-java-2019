/**
 * @Title: SayEnglishName.java
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
public class SayEnglishName implements SayName {

    @Override
    public void say() {
        System.out.println("Andy Lau");
    }
}