package com.zhurong.designpattern.xingweixing11.observer;

/**
 * 2019/11/21
 */
public class TestObserver {

    public static void main(String[] args) {
        Boss boss = new Boss();
        Secretary secretary = new Secretary();
        boss.addObserver(secretary);
        boss.setStatus("我饿了");
    }

}