/**
 * @Title: TestProtoBufUtil.java
 * @Package: com.zhurong.utils.protobuf
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.utils.protobuf;

import com.zhurong.utils.idgen.UuidUtil;
import java.util.Arrays;

/**
 * @description:
 * @author LZG
 * @date 2019/5/22
 */
public class TestProtoBufUtil {

    public static void main(String[] args) {

        Hero gaiLun = new Hero();
        gaiLun.setId(UuidUtil.get32UUIDStr());
        gaiLun.setName("盖伦");
        gaiLun.setAge("25");
        gaiLun.setWeapon("大宝剑");

        byte[] serializerResult = ProtoBufUtil.serializer(gaiLun);
        System.out.println("serializer result: " + Arrays.toString(serializerResult));

        Hero deSerializerResult = ProtoBufUtil.deserializer(serializerResult, Hero.class);
        System.out.println("deSerializerResult: " + deSerializerResult.toString());

    }

}