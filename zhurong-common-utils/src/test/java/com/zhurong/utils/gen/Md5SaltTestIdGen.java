/**   
 * @Title: TestIdGen.java
 * @Package: com.zhurong.utils.gen
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.utils.gen;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * @description: 身份证生成器test
 * @author LZG
 * @date 2018/10/29
 */
public class Md5SaltTestIdGen {

    @Test
    public void test() {
        IdCardGen g = new IdCardGen();
        List<String> idCardList = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            idCardList.add(g.generate());
        }

        for (String idCardStr : idCardList) {
            System.out.println("身份证号：" + idCardStr);
            System.out.println("是否是有效身份证：" + IdCardValidateUtil.validateCard(idCardStr));
            System.out.println("--------------------------");
        }
    }
}