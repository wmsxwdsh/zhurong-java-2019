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
public class Md5SaltTestIdUtil {

    @Test
    public void test1() {
        for(int i = 0; i < 10; i ++) {
            System.out.println(IdGenerator.getRandomIdByUUID());
        }
        //32位
        System.out.println("每个id的长度为" + IdGenerator.getRandomIdByUUID().length());
    }


    @Test
    public void test2() {
        for(int i = 0; i < 10; i++) {
            System.out.println(IdGenerator.getIncreaseIdByNanoTime());
        }
    }

    @Test
    public void test3() {
        System.out.println("System.nanoTime()的长度" + String.valueOf(System.nanoTime()).length()); //15位
        System.out.println("System.currentTimeMillis()的长度" + String.valueOf(System.currentTimeMillis()).length()); //13位

        System.out.println("IdUtil.getIncreaseIdByNanoTime()每个id的长度为" + IdGenerator.getIncreaseIdByNanoTime().length());
        System.out.println("IdUtil.getIncreaseIdByCurrentTimeMillis()每个id的长度为" + IdGenerator.getIncreaseIdByCurrentTimeMillis().length());
    }

}