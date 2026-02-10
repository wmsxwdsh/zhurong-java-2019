package com.zhurong.spi;

public class SayChineseName implements SayName {

    @Override
    public void say() {
        System.out.println("刘德华");
    }
}