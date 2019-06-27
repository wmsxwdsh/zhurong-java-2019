/**   
 * @Title: ClientTest.java
 * @Package: com.zhurong.algorithm.redPackage
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 https://onezg.cnblogs.com
 */
package com.zhurong.algorithm.redPackage;

/**
 * @description: 
 * @author LZG
 * @date 2018/11/28
 */
public class ClientTest {

    public static void main(String[] args) {
        WxRedPackage redPackage = new WxRedPackage(3, 41300);

        while(redPackage.remainSize != 0) {
            double randomMoney = WxRedPackageAlgorithm.getRandomMoney(redPackage);
            System.out.println(randomMoney);
        }
    }
}