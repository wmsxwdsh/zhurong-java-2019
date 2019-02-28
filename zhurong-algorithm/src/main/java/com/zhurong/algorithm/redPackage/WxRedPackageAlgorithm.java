/**   
 * @Title: WxRedPackageAlgorithm.java
 * @Package: com.zhurong.algorithm.redPackage
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 https://onezg.cnblogs.com
 */
package com.zhurong.algorithm.redPackage;

import java.util.Random;

/**
 * @description: 微信红包算法
 *      --摘自：https://www.zhihu.com/question/22625187/answer/85530416
 * @author LZG
 * @date 2018/11/28
 */
public class WxRedPackageAlgorithm {

    /**
     * @Description: 随机获取红包金额
     * @param redPackage
     * @return double
     * @author LZG
     * @date 2018/11/28
     */
    public static double getRandomMoney(WxRedPackage redPackage) {

        if(redPackage.remainSize == 1) {
            redPackage.remainSize--;
            return (double)Math.round(redPackage.remainMoney * 100) / 100;
        }

        Random random = new Random();
        double min = 0.01;
        double max = redPackage.remainMoney / redPackage.remainSize * 2;
        double money = random.nextDouble() * max;
        money = money <= min ? min : money;
        money = Math.floor(money * 100) / 100;
        redPackage.remainSize--;
        redPackage.remainMoney -= money;
        return money;
    }

}