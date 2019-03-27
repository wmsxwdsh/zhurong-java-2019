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

    @Test
    public void test2() {
        String test1Str = "HHHHello_World";
        System.out.println(StringUtil.replaceUnderLine(test1Str)); //输出：HHHHelloWorld

        String test2Str = "project_group";
        System.out.println(StringUtil.replaceUnderLine(test2Str)); //输出：projectGroup
    }

    @Test
    public void test3() {
        String packageName = "com.essence.edop.utils";
        System.out.println(StringUtil.package2path(packageName));
    }

    @Test
    public void test4() {
        String className = "Proje_ctDataSource";
        System.out.println(StringUtil.upperCharToUnderLine(className)); //输出：proje_ct_data_source
    }
}