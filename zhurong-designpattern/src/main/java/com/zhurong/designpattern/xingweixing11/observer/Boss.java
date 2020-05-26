/**   
 * @Title: Boss.java
 * @Package: com.zhurong.designpattern.xingweixing11.observer
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 https://onezg.cnblogs.com
 */
package com.zhurong.designpattern.xingweixing11.observer;

import java.util.Observable;

/**
 * @description: 
 * @author LZG
 * @date 2019/11/21
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