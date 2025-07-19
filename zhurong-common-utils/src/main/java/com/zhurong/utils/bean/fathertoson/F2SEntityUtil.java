package com.zhurong.utils.bean.fathertoson;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 父转子 Util
 * @date 2020年06月22日
 */
public class F2SEntityUtil {

    /**
     * @param oF : 父实体
     * @param oS : 子实体
     * @date 2020/6/22
     */
    public static Object doJob(Object oF, Object oS)  {

        if (!oF.getClass().isAssignableFrom(oS.getClass()))
            throw new RuntimeException("F2SEntityUtil Exception - oS is not extends OF.");

        Class<?> fClass = oF.getClass();
        Class<?> sClass = oS.getClass();
        Object sObject = null;
        try {
            sObject = sClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Object fObject = oF;

        Method[] sMethods = sClass.getMethods();
        Method[] fMethods = fClass.getDeclaredMethods();
        for (Method sMethod : sMethods) {
            String sMethodName = sMethod.getName();

            if (sMethodName.startsWith("set")) {
                Object setValue = null;
                for (Method fMethod : fMethods) {
                    if (Arrays.asList(fMethods).contains(sMethod)) {
                        String fMethodName = fMethod.getName();
                        if (fMethodName.startsWith("get")) {

                            if (fMethodName.substring(3).equals(sMethodName.substring(3))) {
                                fMethod.setAccessible(true);
                                try {
                                    setValue = fMethod.invoke(fObject, null);
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                } catch (InvocationTargetException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        sMethod.setAccessible(true);
                        try {
                            sMethod.invoke(sObject, setValue);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return sObject;
    }

}