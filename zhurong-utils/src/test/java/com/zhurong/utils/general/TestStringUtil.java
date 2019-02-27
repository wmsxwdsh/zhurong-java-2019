/**   
 * @Title: TestStringUtil.java
 * @Package: com.zhurong.utils.general
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.general;

import org.junit.Test;

/**
 * @description: StringUtil测试类
 * @author LZG
 * @date 2018/8/24
 */
public class TestStringUtil {

    @Test
    public void testReplace() {

        String resultIdCard = StringUtil.replace("370684198208132259", 10, 14, '*');
        System.out.println(resultIdCard); //输出: 3706841982****2259

        String resultMobile = StringUtil.replace("18768810050", 3, 7, '*');
        System.out.println(resultMobile); //输出: 187****0050

    }
}