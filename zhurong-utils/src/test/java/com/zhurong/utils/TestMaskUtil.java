/**
 * @Title: TestMaskUtil.java
 * @Package: com.zhurong.utils
 * @author LZG, liuzg@12366.com
 * Copyright (c) 2020 http://www.12366.com
 */
package com.zhurong.utils;

import org.junit.Test;

/**
 * @description:
 * @author LZG
 * @date 2020年06月15日
 */
public class TestMaskUtil {

    //身份证号脱敏测试
    @Test
    public void test1() {
        String s = MaskUtil.iDCardDecryption("511402199104096753");
        System.out.println(s);
    }

    //手机号脱敏
    @Test
    public void test2() {
        String s = MaskUtil.phoneDesensitization("18911387565");
        System.out.println(s);
    }

    //银行卡号脱敏
    @Test
    public void test3() {
        MaskUtil.bankCard("");
    }

    //uuid和短uuid
    @Test
    public void test4() {
        System.out.println(MaskUtil.getUUid());
        System.out.println(MaskUtil.getRandomNum());
    }


}