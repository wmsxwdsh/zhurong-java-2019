/**   
 * @Title: TestRegexUtil.java
 * @Package: com.zhurong.utils.general
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.general;

import org.junit.Test;

/**
 * @description: RegexUtil测试类
 * @author LZG
 * @date 2018/8/24
 */
public class TestRegexUtil {

    @Test
    public void test1() {

        System.out.println(RegexUtil.isLetter("safsadfdasfsafsaf")); //true
        System.out.println(RegexUtil.isLetter("afswqerqr  wqerq")); //false
        System.out.println(RegexUtil.isLetterNum("21312355555_")); //fale
        System.out.println(RegexUtil.isLetterNum("2341  1123")); //false
        System.out.println(RegexUtil.isLetterNumUnderline("21312355555_")); //true
    }

    @Test
    public void test2() {
        System.out.println(RegexUtil.isNumber("3806841987")); //true
        System.out.println(RegexUtil.isNumber("38068419   87")); //false
        System.out.println(RegexUtil.isNumber("03806841987")); //true
    }

    @Test
    public void test3() {
        //验证qq号
        System.out.println(RegexUtil.isQQ("6355558   03")); //false
        System.out.println(RegexUtil.isQQ("635555803")); //true
    }

}