/**
 * @Title: TestArrayListDelete.java
 * @Package: com.zhurong.jdk.base
 * @author LZG, liuzhongguo@cdvcloud.com
 * Copyright (c) 2020 https://www.yunshicloud.com
 */
package com.zhurong.jdk.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LZG
 * @description:
 * @date 2020年05月27日
 */
public class TestArrayListDelete {

    public static void main(String[] args) {
//        zhengXiangDel();
        fanXiangDelete();
    }

    /**
     * 正向删除
     * 问题：for循环正向删除，会遗漏连续重复的元素。
     */
    public static void zhengXiangDel() {
        List<String> list = new ArrayList<String>();

        list.add("111");
        list.add("222");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("333");

        //for循环正向循环删除
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("222")) {
                list.remove(i);
            }
        }
        System.out.println(Arrays.toString(list.toArray()));
    }

    /**
     * 反向删除
     * 反向删除是没问题的。
     */
    public static void fanXiangDelete() {
        List<String> list = new ArrayList<String>();

        list.add("111");
        list.add("222");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("333");

        //for循环反向循环删除
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).equals("222")) {
                list.remove(i);
            }
        }
        System.out.println(Arrays.toString(list.toArray()));
    }


}