/**   
 * @Title: LinkStrUtil.java
 * @Package: com.essence.euauth.web.security
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.utils.security;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 连接字符串工具类
 *      --1、常用于json串加签
 *      --2、可以对参数进行ASCII码排序
 * @author LZG
 * @date 2019/5/17
 */
public class LinkStrUtil {

    /**
     * @param params   元素集合Map
     * @param needSort 是否对key按ASCII码排序
     * @return java.lang.String
     * @Description: 把Map所有元素按照"参数=参数值"的模式用&拼接的字符串
     * @author LZG
     * @date 2018/8/27
     */
    public static String createLinkString(Map<String, Object> params, boolean needSort) {

        List<String> keys = new ArrayList<String>(params.keySet());

        //对key按ASCII码顺序提序
        if (needSort)
            Collections.sort(keys);

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            Object value = params.get(key);

            if (value instanceof HashMap) {
                @SuppressWarnings("unchecked")
                HashMap<String, Object> valueHashMap = (HashMap<String, Object>) value;
                value = "{" + createLinkString(valueHashMap, needSort) + "}";
            }

            //null不参与签名、""(空串)不参与签名、sign_info不参与签名
            if (null == value || "".equals(value) || key.equalsIgnoreCase("signInfo")) {
                continue;
            }

            stringBuilder.append(key);
            stringBuilder.append("=");
            stringBuilder.append(value.toString());
            stringBuilder.append("&");

        }

        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        return stringBuilder.toString();
    }

}