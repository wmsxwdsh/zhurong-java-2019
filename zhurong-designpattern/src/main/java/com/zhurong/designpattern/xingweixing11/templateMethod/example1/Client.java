/**   
 * @Title: Client.java
 * @Package: com.zhurong.designpattern.xingweixing11.mobanfangfams
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.designpattern.xingweixing11.templateMethod.example1;

/**
 * @description: 
 * @author LZG
 * @date 2019/3/18
 */
public class Client {

    public static void main(String[] args) {
        Student student = new Student();
        student.prepareGoToSchool();

        System.out.println("-----------");

        Teacher teacher = new Teacher();
        teacher.prepareGoToSchool();
    }
}