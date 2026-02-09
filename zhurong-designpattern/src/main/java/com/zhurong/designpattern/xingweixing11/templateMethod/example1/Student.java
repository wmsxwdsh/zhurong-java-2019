package com.zhurong.designpattern.xingweixing11.templateMethod.example1;

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