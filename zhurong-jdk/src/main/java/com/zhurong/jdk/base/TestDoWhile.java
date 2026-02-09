package com.zhurong.jdk.base;

public class TestDoWhile {

    public static void main(String[] args) {

        int a = 0;
        int c = 0;

        // do while是先进再判断
        do {
            --c;
            a = a -1;
        } while(a > 0);

        System.out.println(c); //-1

    }

}