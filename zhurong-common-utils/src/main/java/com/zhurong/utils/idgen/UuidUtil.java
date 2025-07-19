package com.zhurong.utils.idgen;

import java.util.UUID;

/**
 * Uuid 生成工具类
 * @date 2018/8/24
 */
public class UuidUtil {

    /**
     * 生成 uuid 唯一字符串（32位）
     * @date 2018/8/24
     */
    public static String get32UUIDStr() {
        String uuidStr = "";
        UUID uuid = UUID.randomUUID();
        uuidStr = uuid.toString().replace("-", "");
        return uuidStr;
    }


    // 测试一下
    public static void main(String[] args) {
//        String uuidStr = get32UUIDStr();
//        System.out.println(uuidStr);
//        System.out.println(uuidStr.length());

        for(int i = 0; i < 5; i++) {
            System.out.println(get32UUIDStr());
        }
    }

}