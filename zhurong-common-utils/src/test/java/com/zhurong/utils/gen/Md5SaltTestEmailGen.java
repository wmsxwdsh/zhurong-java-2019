/**   
 * @Title: TestEmailGen.java
 * @Package: com.zhurong.utils.gen
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.utils.gen;

import org.junit.Test;

/**
 * @description: 邮箱生成器test
 * @author LZG
 * @date 2018/11/5
 */
public class Md5SaltTestEmailGen {

    @Test
    public void test1() {
        for (int i = 0; i < 5; i++) {
            String email = EmailGen.generate();
            System.out.println(email);
        }
    }

}