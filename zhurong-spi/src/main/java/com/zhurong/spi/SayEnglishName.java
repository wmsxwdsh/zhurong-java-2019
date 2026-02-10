package com.zhurong.spi;

public class SayEnglishName implements SayName {

    @Override
    public void say() {
        System.out.println("Andy Lau");
    }
}