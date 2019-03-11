/**
 * @Title: TestCallable.java
 * @Package: com.zhurong.jdk.java8.lambda
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.jdk.java8.lambda;

import com.zhurong.utils.gen.ChineseNameGen;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description: 只有一个方法的接口，被声明成@FunctionalInterface就是函数式接口了。
 * @author LZG
 * @date 2019/3/11
 */
public class TestCallable {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
//            Callable<String> task = new Callable<String>() {
//                @Override
//                public String call() throws Exception {
//                    return ChineseNameGen.generate();
//                }
//            };

            //()表示的是方法需要的参数，这种表达方法就是函数式表达式
            Callable<String> task = () -> ChineseNameGen.generate();

            Future<String> submit = executor.submit(task);
            try {
                System.out.println(submit.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }

    }

}