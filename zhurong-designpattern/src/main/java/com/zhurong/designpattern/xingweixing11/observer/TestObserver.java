/**   
 * @Title: TestObserver.java
 * @Package: com.zhurong.designpattern.xingweixing11.observer
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 https://onezg.cnblogs.com
 */
package com.zhurong.designpattern.xingweixing11.observer;

/**
 * @description: 
 * @author LZG
 * @date 2019/11/21
 */
public class TestObserver {

    public static void main(String[] args) {
        Boss boss = new Boss();
        Secretary secretary = new Secretary();
        boss.addObserver(secretary);
        boss.setStatus("我饿了");
    }

}