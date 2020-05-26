/**
 * @Title: Test.java
 * @Package: com.zhurong.spi
 * @author LZG, liuzhongguo@cdvcloud.com
 * Copyright (c) 2020 https://www.yunshicloud.com
 */
package com.zhurong.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @description:
 * @author LZG
 * @date 2020年05月26日
 */
public class Test {

    public static void main(String[] args) {
        ServiceLoader<SayName> serviceLoader = ServiceLoader.load(SayName.class);

        Iterator<SayName> iterator = serviceLoader.iterator();

        while(iterator.hasNext()) {
            SayName sayName = iterator.next();
            sayName.say();
        }
    }
}