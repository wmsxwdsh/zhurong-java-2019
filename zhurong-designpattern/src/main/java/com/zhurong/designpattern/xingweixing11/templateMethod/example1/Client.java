package com.zhurong.designpattern.xingweixing11.templateMethod.example1;

public class Client {

    public static void main(String[] args) {
        Student student = new Student();
        student.prepareGoToSchool();

        System.out.println("-----------");

        Teacher teacher = new Teacher();
        teacher.prepareGoToSchool();
    }
}