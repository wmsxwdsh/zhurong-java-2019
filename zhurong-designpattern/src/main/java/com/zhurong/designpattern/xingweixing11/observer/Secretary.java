/**   
 * @Title: Secretary.java
 * @Package: com.zhurong.designpattern.xingweixing11.observer
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 https://onezg.cnblogs.com
 */
package com.zhurong.designpattern.xingweixing11.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @description: 
 * @author LZG
 * @date 2019/11/21
 */
public class Secretary implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("秘书做出了行为" + arg);
    }

}