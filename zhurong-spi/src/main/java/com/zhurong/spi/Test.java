package com.zhurong.spi;

import java.util.ServiceLoader;

public class Test {

    public static void main(String[] args) {
        ServiceLoader<SayName> serviceLoader = ServiceLoader.load(SayName.class);

        for (SayName sayName : serviceLoader) {
            sayName.say();
        }
    }
}