/**   
 * @Title: Teacher.java
 * @Package: com.zhurong.designpattern.xingweixing11.mobanfangfams
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.designpattern.xingweixing11.templateMethod.example1;

/**
 * @description: 
 * @author LZG
 * @date 2019/3/18
 */
public class Teacher extends AbstractPerson {

    @Override
    protected void dressUp() {
        System.out.println("穿工作服");
    }

    @Override
    protected void eatBreakfast() {
        System.out.println("做早饭吃饭");
    }

    @Override
    protected void takeThings() {
        System.out.println("带上昨晚准备的考卷出发");
    }

}