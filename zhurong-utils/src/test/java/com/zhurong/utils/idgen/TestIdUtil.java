/**   
 * @Title: TestIdUtil.java
 * @Package: com.zhurong.utils.idgen
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.idgen;

import org.junit.Test;

/**
 * @description: 
 * @author LZG
 * @date 2018/11/20
 */
public class TestIdUtil {

    @Test
    public void test1() {
        for(int i = 0; i < 10; i ++) {
            System.out.println(IdUtil.getRandomIdByUUID());
        }
        //32位
        System.out.println("每个人id的长度为" + IdUtil.getRandomIdByUUID().length());
    }


    @Test
    public void test2() {
        for(int i = 0; i < 10; i++) {
            System.out.println(IdUtil.getIncreaseIdByNanoTime());
        }
    }

}