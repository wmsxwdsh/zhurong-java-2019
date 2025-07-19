/**   
 * @Title: TestTimeWatchUtil.java
 * @Package: com.zhurong.utils.general
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.common;

import org.junit.Test;

/**
 * @description: 
 * @author LZG
 * @date 2018/11/5
 */
public class Md5SaltTestTimeWatchUtil {

    @Test
    public void test() throws InterruptedException {
        TimeWatchUtil tw = TimeWatchUtil.createTimeWatch("往DB添加1万条数据");

        Thread.sleep(10000);
        tw.addStep("1");

        Thread.sleep(5000);
        tw.addStep("2");

        System.out.println(tw.outputTimeList());
    }

}