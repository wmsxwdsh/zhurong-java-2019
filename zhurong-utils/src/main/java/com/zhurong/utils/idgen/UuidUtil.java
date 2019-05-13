/**
 * @Title: UuidUtil.java
 * @Package: com.zhurong.utils.general
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.idgen;

import java.util.UUID;

/**
 * @description: uuid工具类
 * @author LZG
 * @date 2018/8/24
 */
public class UuidUtil {

    /**
     * @Description: 生成uuid唯一字符串(32位)
     * @return java.lang.String
     * @author LZG
     * @date 2018/8/24
     */
    public static String get32UUIDStr() {
        String uuidStr = "";
        UUID uuid = UUID.randomUUID();
        uuidStr = uuid.toString().replace("-", "");
        return uuidStr;
    }

    /**
     * @Description: 测试方法
     * @param args
     * @return void
     * @author LZG
     * @date 2018/8/24
     */
    public static void main(String[] args) {
//        String uuidStr = get32UUIDStr();
//        System.out.println(uuidStr);
//        System.out.println(uuidStr.length());

        for(int i = 0; i < 5; i++) {
            System.out.println(get32UUIDStr());
        }
    }

}