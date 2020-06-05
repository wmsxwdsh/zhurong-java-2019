/**
 * @Title: MultiValueMapTest.java
 * @Package: com.yuzhong.myspringboot.util
 * @author LZG, liuzhongguo@cdvcloud.com
 * Copyright (c) 2020 https://www.yunshicloud.com
 */
package com.yuzhong.myspringboot.v1.util;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Set;

/**
 * @description: MultiValueMap, 一个key可以对应多个value
 * @author LZG
 * @date 2020年03月16日
 */
public class MultiValueMapTest {

    public static void main(String[] args) {
        MultiValueMap<Integer, String> multiValueMap = new LinkedMultiValueMap<>();

        multiValueMap.add(1, "鼠");
        multiValueMap.add(1, "大娃");
        multiValueMap.add(1, "诸葛谨");

        multiValueMap.add(2, "牛");
        multiValueMap.add(2, "二娃");
        multiValueMap.add(2, "诸葛亮");


        Set<Integer> keySet = multiValueMap.keySet();

        for(Integer key : keySet) {
            List<String> values = multiValueMap.get(key);

            System.out.println("key:" + key + " , value:" + values.toString());
        }

    }
}