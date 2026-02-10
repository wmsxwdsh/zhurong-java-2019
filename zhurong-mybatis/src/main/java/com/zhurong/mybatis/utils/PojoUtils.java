package com.zhurong.mybatis.utils;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class PojoUtils<V, E> {
    public PojoUtils() {
    }

    public static <E> E convertPojo(Object srcClass, Class<E> tarClass) {
        if (srcClass == null) {
            return null;
        } else if (tarClass == null) {
            return null;
        } else {
            try {
                E newInstance = tarClass.newInstance();
                BeanUtils.copyProperties(srcClass, newInstance);
                return newInstance;
            } catch (Exception var3) {
                return null;
            }
        }
    }

    public static <T, V> PageUtils<V> pageVo(PageUtils<T> srcPage, Class<V> tarClass) {
        List<V> voList = (List)srcPage.getList().stream().map((item) -> {
            try {
                return convertPojo(item, tarClass.newInstance().getClass());
            } catch (InstantiationException var3) {
                var3.printStackTrace();
            } catch (IllegalAccessException var4) {
                var4.printStackTrace();
            }

            return null;
        }).collect(Collectors.toList());
        PageUtils<V> tarPage = new PageUtils(voList, srcPage.getTotalCount(), srcPage.getPageSize(), srcPage.getCurrPage());
        tarPage.setList(voList);
        return tarPage;
    }

    public static <T, V> List<V> listPojo(List<T> srcList, Class<V> tarClass) {
        List<V> voList = (List)srcList.stream().map((item) -> {
            try {
                return convertPojo(item, tarClass.newInstance().getClass());
            } catch (InstantiationException var3) {
                var3.printStackTrace();
            } catch (IllegalAccessException var4) {
                var4.printStackTrace();
            }

            return null;
        }).collect(Collectors.toList());
        return voList;
    }
}