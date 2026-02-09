package com.zhurong.concurrency.zhanglong.example1;

public class Client {

    public static void main(String[] args) {

        MyObject myObject = new MyObject();

        Thread increaseThread = new Thread(new IncreaseThread(myObject));
        Thread decreaseThread = new Thread(new DecreaseThread(myObject));

        Thread increaseThread2 = new Thread(new IncreaseThread(myObject));
        Thread decreaseThread2 = new Thread(new DecreaseThread(myObject));


        increaseThread.start();
        decreaseThread.start();

        increaseThread2.start();
        decreaseThread2.start();

    }

}