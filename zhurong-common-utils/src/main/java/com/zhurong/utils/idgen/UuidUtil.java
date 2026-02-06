package com.zhurong.utils.idgen;

import java.util.UUID;

/**
 * Uuid 生成工具类
 * 2018/8/24
 */
public class UuidUtil {

    /**
     * 生成 uuid 唯一字符串（32位）
     * 生成的 UUID 带-的字符串，类似于：a5c8a5e8-df2b-4706-bea4-08d0939410e3
     * 生成的 UUID 不带-的字符串，类似于：b17f24ff026d40949c85a24f4f375d42
     */
    public static String get32UUIDStr() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }

    // 测试一下
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            System.out.println(get32UUIDStr());
        }
    }

}