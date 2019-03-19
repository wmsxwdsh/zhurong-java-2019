/**   
 * @Title: LianJiaCglibProxy.java
 * @Package: com.zhurong.designpattern.jiegouxing7.proxy.cglibProxy
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.designpattern.jiegouxing7.proxy.cglibProxy;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @description: 
 * @author LZG
 * @date 2019/3/19
 */
public class LianJiaCglibProxy implements MethodInterceptor {

    private Object targetObject; //被代理对象

    // 这里的目标类型为Object，则可以接受任意一种参数作为被代理类，实现了动态代理
    public Object getInstance( Object targetObject) {
        this.targetObject = targetObject;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetObject.getClass());
        enhancer.setCallback(this);
        //注意该处代理的创建过程
        Object proxyObj = enhancer.create();
        return proxyObj;// 返回代理对象
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object obj = null;
        System.out.println("doSomething---------start");
        obj = method.invoke(targetObject, args);
        System.out.println("doSomething---------end");
        return obj;
    }
}