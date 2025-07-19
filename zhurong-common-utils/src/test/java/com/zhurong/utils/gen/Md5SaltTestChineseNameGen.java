/**   
 * @Title: TestChineseNameGen.java
 * @Package: com.zhurong.utils.gen
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.utils.gen;

import org.junit.Test;

/**
 * @description: 中文姓名生成器test
 * @author LZG
 * @date 2018/11/5
 */
public class Md5SaltTestChineseNameGen {

    @Test
    public void test() {
        for(int i = 0; i < 10; i++) {
            System.out.println(ChineseNameGen.generate());
        }
    }

}