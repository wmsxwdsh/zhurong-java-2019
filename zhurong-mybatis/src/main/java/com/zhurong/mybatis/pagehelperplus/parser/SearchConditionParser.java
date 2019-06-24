/**
 * @Title: SearchConditionParser.java
 * @Package: com.zhurong.mybatis.pagehelper.util
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.mybatis.pagehelperplus.parser;

import com.zhurong.db.persistence.domain.CityInfoExample;
import com.zhurong.db.persistence.domain.CityInfoExample.Criteria;
import com.zhurong.mybatis.pagehelperplus.SearchCondition;
import com.zhurong.utils.date.DateUtil;
import com.zhurong.utils.general.StringUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @description: 模糊查询条件解析器
 * @author LZG
 * @date 2019/6/21
 */
public class SearchConditionParser {

    public static CityInfoExample coverToExample(List<SearchCondition> searchInfos) {
        CityInfoExample example = new CityInfoExample();
        Criteria criteria = example.createCriteria();

        int size = searchInfos.size();

        for (int i = 0; i < size; i++) {
            SearchCondition search = searchInfos.get(i);
            String property = search.getProperty();
            String mate = search.getMate();
            String value = search.getValue();

            String methodName = getMethodName(property, mate, value);
            criteria = handleCriteria(criteria, methodName, value);
        }
        return example;
    }

    private static Criteria handleCriteria(Criteria criteria, String methodName, String value) {
        if (StringUtil.isBlank(value)) {
            return criteria;
        }
        Class<?> clazz = Criteria.class;

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            String mName = m.getName();
            if (mName.equals(methodName)) {
                Type[] genericParameterTypes = m.getGenericParameterTypes();
                for (Type type : genericParameterTypes) {
                    m.setAccessible(false);

                    if (type instanceof ParameterizedType) {

                        Type[] inTypes = ((ParameterizedType) type).getActualTypeArguments();
                        String inTypeName = inTypes[0].getTypeName();
                        if (inTypeName.equals("Integer")) {
                            List<Integer> integerList = new ArrayList<>();
                            String[] vArr = value.split(",");
                            int vArrSize = vArr.length;
                            for (int i = 0; i < vArrSize; i++) {
                                integerList.add(Integer.parseInt(vArr[0]));
                            }

                            try {
                                criteria = (Criteria) m.invoke(criteria, integerList);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }

                        if (inTypeName.equals("String")) {
                            List<String> strList = Arrays.asList(value.split(","));
                            try {
                                criteria = (Criteria) m.invoke(criteria, strList);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                        if (inTypeName.equals("Date")) {
                            List<Date> dList = new ArrayList<>();
                            String[] vArr = value.split(",");
                            int vArrSize = vArr.length;
                            for (int i = 0; i < vArrSize; i++) {
                                String sDate = vArr[i];
                                if (-1 == sDate.indexOf(":")) {
                                    dList.add(DateUtil.stringToDate(sDate, DateUtil.FORMAT_YYYY_MM_DD));
                                } else {
                                    dList.add(DateUtil.stringToDate(sDate, DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));
                                }
                            }

                        }

                    } else {
                        if (type.equals(Integer.class)) {
                            Integer intValue = Integer.valueOf(value);
                            try {
                                criteria = (Criteria) m.invoke(criteria, intValue);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                        if (type.equals(String.class)) {

                            try {
                                if (-1 == m.getName().indexOf("Like")) {
                                    criteria = (Criteria) m.invoke(criteria, value);
                                } else {
                                    criteria = (Criteria) m.invoke(criteria, "%" + value + "%");
                                }
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                        if (type.equals(Date.class)) {
                            Date vDate;
                            if (-1 == value.indexOf(":")) {
                                vDate = DateUtil.stringToDate(value, DateUtil.FORMAT_YYYY_MM_DD);
                            } else {
                                vDate = DateUtil.stringToDate(value, DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);
                            }
                            try {
                                criteria = (Criteria) m.invoke(criteria, vDate);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }

                        }
                    }

                }
            }
        }
        return criteria;
    }

    private static String getMethodName(String property, String mate, String value) {
        String formatProperty = StringUtil.upperCaseFist(property);
        String methodName = "and";

        switch (mate) {
            case "is":
                if (value.trim().equals("null")) {
                    methodName += formatProperty + "IsNull";
                }
                if (value.trim().equals("not null")) {
                    methodName += formatProperty + "IsNotNull";
                }
                break;
            case "=":
                methodName += formatProperty + "EqualTo";
                break;
            case "<>":
                methodName += formatProperty + "NotEqualTo";
                break;

            case ">":
                methodName += formatProperty + "GreaterThan";
                break;
            case ">=":
                methodName += formatProperty + "GreaterThanOrEqualTo";
                break;
            case "<":
                methodName += formatProperty + "LessThan";
                break;
            case "<=":
                methodName += formatProperty + "LessThanOrEqualTo";
                break;

            case "in":
                methodName += formatProperty + "In";
                break;
            case "not in":
                methodName += formatProperty + "NotIn";
                break;
            case "like":
                methodName += formatProperty + "Like";
                break;

            //以下两个暂不支持
            case "between":
                methodName += formatProperty + "Between";
                break;
            case "not between":
                methodName += formatProperty + "NotBetween";
                break;
        }

        return methodName;
    }

}