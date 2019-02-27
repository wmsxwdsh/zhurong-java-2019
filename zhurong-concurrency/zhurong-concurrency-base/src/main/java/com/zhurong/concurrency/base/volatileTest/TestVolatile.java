package com.zhurong.concurrency.base.volatileTest;

public class TestVolatile {

    public static volatile int numb = 0;

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 100; i++) {

            new Thread(new Runnable() {

                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        numb++;
                    }
                }
            }).start();

        }

        System.out.println(numb);
    }

}
