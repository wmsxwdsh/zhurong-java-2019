/**
 * @Title: Student.java
 * @Package: com.zhurong.designpattern.xingweixing11.mobanfangfams
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.designpattern.xingweixing11.mobanfangfams.example1;

/**
 * @description:
 * @author LZG
 * @date 2019/3/18
 */
public class Student extends AbstractPerson {

    @Override
    protected void dressUp() {
        System.out.println("穿校服");
    }

    @Override
    protected void eatBreakfast() {
        System.out.println("吃妈妈做好的早餐");
    }

    @Override
    protected void takeThings() {
        System.out.println("带着作业出发");
    }

}