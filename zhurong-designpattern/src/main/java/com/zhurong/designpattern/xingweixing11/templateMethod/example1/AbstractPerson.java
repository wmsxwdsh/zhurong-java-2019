package com.zhurong.designpattern.xingweixing11.templateMethod.example1;

public abstract class AbstractPerson {

    //抽象类定义整个骨架流程
    public void prepareGoToSchool() {
        dressUp();
        eatBreakfast();
        takeThings();
    }

    //以下是不同子类根据自身特性完成的具体步骤
    protected abstract void dressUp();
    protected abstract void eatBreakfast();
    protected abstract void takeThings();

    //这里也可以定义方法实现，子类可实现可不实现
    //HttpServlet就是这么做的，参考example2
    protected void lookMyself() {
        System.out.println("通过镜子给自己一个迷人的微笑");
    }

}