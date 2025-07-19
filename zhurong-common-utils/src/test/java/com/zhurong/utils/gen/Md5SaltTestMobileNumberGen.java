/**   
 * @Title: TestMobileNumberGen.java
 * @Package: com.zhurong.utils.gen
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.utils.gen;

import org.junit.Test;

/**
 * @description: 手机号码生成器test
 * @author LZG
 * @date 2018/11/5
 */
public class Md5SaltTestMobileNumberGen {

    @Test
    public void test() {
        //生成真手机号码
        String result = MobileNumberGen.generate();
        System.out.println(result);

        //生成假的手机号码
        String result2 = MobileNumberGen.generateFake();
        System.out.println(result2);
    }

}