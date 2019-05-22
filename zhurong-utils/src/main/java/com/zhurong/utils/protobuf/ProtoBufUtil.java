/**   
 * @Title: ProtoBufUtil.java
 * @Package: com.zhurong.utils.protobuf
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.utils.protobuf;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

/**
 * @description: 摘自https://blog.csdn.net/qq_36680439/article/details/79563349
 * @author LZG
 * @date 2019/5/22
 */
public class ProtoBufUtil {

    /**
     * @Description: 序列化
     * @param o
     * @return byte[]
     * @author LZG
     * @date 2019/5/22
     */
    public static <T> byte[] serializer(T o) {
        Schema schema = RuntimeSchema.getSchema(o.getClass());
        return ProtobufIOUtil.toByteArray(o, schema, LinkedBuffer.allocate(256));
    }

    /**
     * @Description: 反序列化
     * @param bytes
     * @param clazz
     * @return T
     * @author LZG
     * @date 2019/5/22
     */
    public static <T> T deserializer(byte[] bytes, Class<T> clazz) {

        T obj = null;
        try {
            obj = clazz.newInstance();
            Schema schema = RuntimeSchema.getSchema(obj.getClass());
            ProtostuffIOUtil.mergeFrom(bytes, obj, schema);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return obj;
    }

}