package com.zhurong.concurrency.zhanglong.example1;

public class IncreaseThread implements Runnable {

    private MyObject myObject;

    public IncreaseThread(MyObject myObject) {
        this.myObject = myObject;
    }

    public void run() {
        for(int i = 0; i < 30; i++) {

            try {
                Thread.sleep((long)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            myObject.increase();
        }
    }

}