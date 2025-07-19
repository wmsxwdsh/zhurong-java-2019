/**   
 * @Title: SelectionSort.java
 * @Package: com.zhurong.algorithm.sort
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.utils.algorithm.sort;

import java.util.Arrays;

/**
 * @description: 选择排序。时间复杂度是O(n²)
 * @author LZG
 * @date 2019/3/8
 */
public class SelectionSort {

    public static void main(String[] args) {

        int[] nums = new int[]{16, 5, 8, 15, 7, 9, 19, 18, 3, 6, 49};

        for(int i = 0; i < nums.length; i++) {

            int min, pos;
            min = nums[i];
            pos = i;

            for(int j = i + 1; j < nums.length; j++) {

                if(nums[j] < min) {
                    min = nums[j];
                    pos = j;
                }
            }

            //将当前位置的值和最小位置的值互换
            int temp = nums[i];
            nums[i] = min;
            nums[pos] = temp;

            System.out.println(Arrays.toString(nums));
        }

        /*
         * 运行结果：
         * [3, 5, 8, 15, 7, 9, 19, 18, 16, 6, 49]
         * [3, 5, 8, 15, 7, 9, 19, 18, 16, 6, 49]
         * [3, 5, 6, 15, 7, 9, 19, 18, 16, 8, 49]
         * [3, 5, 6, 7, 15, 9, 19, 18, 16, 8, 49]
         * [3, 5, 6, 7, 8, 9, 19, 18, 16, 15, 49]
         * [3, 5, 6, 7, 8, 9, 19, 18, 16, 15, 49]
         * [3, 5, 6, 7, 8, 9, 15, 18, 16, 19, 49]
         * [3, 5, 6, 7, 8, 9, 15, 16, 18, 19, 49]
         * [3, 5, 6, 7, 8, 9, 15, 16, 18, 19, 49]
         * [3, 5, 6, 7, 8, 9, 15, 16, 18, 19, 49]
         * [3, 5, 6, 7, 8, 9, 15, 16, 18, 19, 49]
         *
         */

    }

}