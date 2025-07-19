/**   
 * @Title: TestRegexUtil.java
 * @Package: com.zhurong.utils.general
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.common;

import org.junit.Test;

/**
 * @description: RegexUtil测试类
 * @author LZG
 * @date 2018/8/24
 */
public class Md5SaltTestRegexUtil {

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

    @Test
    public void test4() {
        //验证密码规则1
        String str1 = "abc11233443"; //fasle
        String str2 = "abc123??555"; //true
        String str3 = "abcABC123abc"; //true
        System.out.println(RegexUtil.isPassword1(str1));
        System.out.println(RegexUtil.isPassword1(str2));
        System.out.println(RegexUtil.isPassword1(str3));
    }

    @Test
    public void test5() {
        String str1 = "0535-57637228"; //true
        String str2 = "0101-56998951"; //false
        System.out.println(RegexUtil.isHomePhoneNumber(str1));
        System.out.println(RegexUtil.isHomePhoneNumber(str2));
    }

    @Test
    public void test6() {
        String s1 = "wangwei@12366.com";
        boolean result = RegexUtil.isEmail(s1);
        System.out.println(result);
    }

}