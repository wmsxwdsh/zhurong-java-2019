/**   
 * @Title: TestPinyinUtil.java
 * @Package: com.zhurong.utils.general
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.common;

import org.junit.Test;

/**
 * @description: PinyinUtil测试类
 * @author LZG
 * @date 2018/8/24
 */
public class Md5SaltTestPinyinUtil {

    @Test
    public void testGetAllLetter() {

        String result1 = PinyinUtil.getAllLetter("你好"); //正常的
        System.out.println(result1);

        String result2 = PinyinUtil.getAllLetter("  "); //空的
        System.out.println(result2);

        String result3 = PinyinUtil.getAllLetter("hello"); //不是中文字符
        System.out.println(result3);
    }

    @Test
    public void testGetAllFirstLetter() {
        String result = PinyinUtil.getAllFirstLetter("刘德华");
        System.out.println(result);
    }
}