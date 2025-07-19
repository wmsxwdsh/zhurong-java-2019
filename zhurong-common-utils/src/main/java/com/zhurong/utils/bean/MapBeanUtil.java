/**
 * @Title: MapBeanUtil.java
 * @Package: com.zhurong.utils.mapbeanconvert
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.cglib.beans.BeanMap;

/**
 * @description: Map、Bean相互转换工具(使用见测试用例)
 *      --1、ObjectMapper先将bean转换为json，再将json转换为map，效率低下。
 *      --2、通过net.sf.cglib.beans.BeanMap类中的方法，这种方式效率极高，因为使用了缓存。
 * @author LZG
 * @date 2018/8/27
 */
public class MapBeanUtil {

    /**
     * @Description: 将javabean对象装换为map
     * @param bean
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @author LZG
     * @date 2018/8/27
     */
    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key + "", beanMap.get(key));
            }
        }
        return map;
    }

    /**
     * @Description: 将map装换为javabean对象
     * @param map
     * @param bean
     * @return T
     * @author LZG
     * @date 2018/8/27
     */
    public static <T> T mapToBean(Map<String, Object> map, T bean) {
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }

    /**
     * @Description: 将List<T>转换为List<Map<String, Object>>
     * @param objList
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     * @author LZG
     * @date 2018/8/27
     */
    public static <T> List<Map<String, Object>> objectsToMaps(List<T> objList) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        if (objList != null && objList.size() > 0) {
            Map<String, Object> map = null;
            T bean = null;
            for (int i = 0,size = objList.size(); i < size; i++) {
                bean = objList.get(i);
                map = beanToMap(bean);
                list.add(map);
            }
        }
        return list;
    }

    /**
     * @Description: 将List<Map<String,Object>>转换为List<T>
     * @param maps
     * @param clazz
     * @return java.util.List<T>
     * @author LZG
     * @date 2018/8/27
     */
    public static <T> List<T> mapsToObjects(List<Map<String, Object>> maps,Class<T> clazz) {
        List<T> list = new ArrayList<T>();
        if (maps != null && maps.size() > 0) {
            Map<String, Object> map = null;
            T bean = null;
            for (int i = 0,size = maps.size(); i < size; i++) {
                map = maps.get(i);
                try {
                    bean = clazz.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                mapToBean(map, bean);
                list.add(bean);
            }
        }
        return list;
    }

}