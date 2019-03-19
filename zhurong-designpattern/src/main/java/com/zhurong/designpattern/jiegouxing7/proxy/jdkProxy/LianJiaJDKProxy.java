/**   
 * @Title: LianJiaProxy.java
 * @Package: com.zhurong.designpattern.jiegouxing7.proxy.jdkProxy
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.designpattern.jiegouxing7.proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: 
 * @author LZG
 * @date 2019/3/19
 */
public class LianJiaJDKProxy implements InvocationHandler {

    private Object object;// 被代理人

    //这里的目标类型为Object，则可以接受任意一种参数作为被代理类，实现了动态代理。但是要注意下面的newProxyInstance（）中的参数
    public Object getInstance(Object object) {
        this.object = object;
        //与cglib的区别在于这里构建代理对象的时候需要传入被代理对象的接口对象，第二个参数。而cglib不需要被代理对象实现任何接口即可
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("doSomething---------start");
        method.invoke(object, args);
        System.out.println("doSomething---------end");
        return null;
    }
}