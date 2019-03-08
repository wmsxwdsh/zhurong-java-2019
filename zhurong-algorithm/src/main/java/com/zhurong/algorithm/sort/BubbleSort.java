/**
 * @Title: BubbleSort.java
 * @Package: com.zhurong.algorithm.sort
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.algorithm.sort;

import java.util.Arrays;

/**
 * @description: 冒泡排序。时间复杂度O(n²)
 * @author LZG
 * @date 2019/2/28
 */
public class BubbleSort {

    public static int[] nums = new int[]{16, 5, 8, 15, 7, 9, 19, 18, 3, 6, 49};

    public static void main(String[] args) {

        //有多少元素就循环多少遍
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {  //减1，是为了防止取最后一个元素时下标越界
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }

            System.out.println(Arrays.toString(nums));
        }
    }

}