package com.zhurong.utils.protobuf;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

/**
 * 摘自 <a href="https://blog.csdn.net/qq_36680439/article/details/79563349">...</a>
 * 2019/5/22
 */
public class ProtoBufUtil {

    /**
     * 序列化
     * @param o
     * @return byte[]
     */
    public static <T> byte[] serializer(T o) {
        Schema schema = RuntimeSchema.getSchema(o.getClass());
        return ProtobufIOUtil.toByteArray(o, schema, LinkedBuffer.allocate(256));
    }

    /**
     * 反序列化
     * @param bytes
     * @param clazz
     * @return T
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