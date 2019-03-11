/**
 * @Title: InsertionSort.java
 * @Package: com.zhurong.algorithm.sort
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.algorithm.sort;

import java.util.Arrays;

/**
 * @description: 插入排序。时间复杂度O(n²)
 * @author LZG
 * @date 2019/3/11
 */
public class InsertionSort {

    public static void main(String[] args) {

        int[] nums = new int[]{16, 5, 8, 15, 7, 9, 19, 18, 3, 6, 49};

        for (int i = 1; i < nums.length; i++) {

            for (int j = i; j > 0; j--) {

                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }

            System.out.println(Arrays.toString(nums));

        }
    }


}