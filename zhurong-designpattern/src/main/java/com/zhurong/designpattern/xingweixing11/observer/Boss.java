package com.zhurong.designpattern.xingweixing11.observer;

import java.util.Observable;

/**
 * 2019/11/21
 */
public class Boss extends Observable {

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        setChanged();
        //notifyObservers();
        notifyObservers(status);
    }

}