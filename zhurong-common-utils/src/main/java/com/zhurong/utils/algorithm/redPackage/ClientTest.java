package com.zhurong.utils.algorithm.redPackage;

/**
 * 2018/11/28
 */
public class ClientTest {

    public static void main(String[] args) {
        WxRedPackage redPackage = new WxRedPackage(4, 41550);

        while(redPackage.remainSize != 0) {
            double randomMoney = WxRedPackageAlgorithm.getRandomMoney(redPackage);
            System.out.println(randomMoney);
        }
    }

}