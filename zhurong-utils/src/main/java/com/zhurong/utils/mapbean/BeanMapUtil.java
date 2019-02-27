/**   
 * @Title: BeanMapUtil.java
 * @Package: com.zhurong.utils.mapbean
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.mapbean;

import com.google.common.base.CaseFormat;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Map;
import java.util.TreeMap;

/**
 * @description: Bean和Map相互转换的工具(github微信支付)
 * @author LZG
 * @date 2018/10/26
 */
public class BeanMapUtil {

    /**
     * @Description: object转换成Map
     * @param object
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @author LZG
     * @date 2018/10/26
     */
    public static Map<String, Object> object2Map(Object object) {
        Map<String, Object> data = new TreeMap<String, Object>(); //对key进行排序
        try {
            BeanInfo info = Introspector.getBeanInfo(object.getClass(), Introspector.IGNORE_ALL_BEANINFO);
            PropertyDescriptor[] descriptors = info.getPropertyDescriptors();
            for (PropertyDescriptor pd : descriptors) {
                // 将 驼峰式写法转成下划线写法
                String name = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, pd.getName());
                Object value = pd.getReadMethod().invoke(object);
                if ("class".equals(name) || value == null)
                    continue;
                data.put(name, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * @Description: Map转换成Bean
     * @param clazz
     * @param data
     * @return T
     * @author LZG
     * @date 2018/10/26
     */
    public static <T> T map2Object(Class<T> clazz, Map<String, Object> data) {
        try {
            T object = clazz.newInstance();
            BeanInfo info = Introspector.getBeanInfo(object.getClass(), Introspector.IGNORE_ALL_BEANINFO);
            PropertyDescriptor[] descriptors = info.getPropertyDescriptors();
            for (PropertyDescriptor pd : descriptors) {
                String name = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, pd.getName());

                Object value = data.get(name);
                if (value == null)
                    continue;
                pd.getWriteMethod().invoke(object, value);

            }
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}