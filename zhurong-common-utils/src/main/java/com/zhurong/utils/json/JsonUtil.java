/**   
 * @Title: JsonUtil.java
 * @Package: com.zhurong.utils.json
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

/**
 * @description: json工具类
 * @author LZG
 * @date 2018/8/27
 */
public class JsonUtil {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * @Description: 将对象转换成json字符串
     * @param data
     * @return java.lang.String
     * @author LZG
     * @date 2018/8/27
     */
    public static String objectToJson(Object data) {
        try {
            String string = MAPPER.writeValueAsString(data);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Description: 将json结果集转化为对象
     * @param jsonData json数据
     * @param beanType 对象中的object类型
     * @return T
     * @author LZG
     * @date 2018/8/27
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Description: 将json数据转换成pojo对象list
     * @param jsonData
     * @param beanType
     * @return java.util.List<T>
     * @author LZG
     * @date 2018/8/27
     */
    public static <T>List<T> jsonToList(String jsonData, Class<T> beanType) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            List<T> list = MAPPER.readValue(jsonData, javaType);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}