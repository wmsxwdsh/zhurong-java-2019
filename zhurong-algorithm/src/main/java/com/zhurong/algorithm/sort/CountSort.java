/**   
 * @Title: CountSort.java
 * @Package: com.zhurong.algorithm.sort
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.algorithm.sort;

import java.util.Arrays;

/**
 * @description: 计数排序。时间复杂度O(n+k),其中k是整数的范围
 * @author LZG
 * @date 2019/3/11
 */
public class CountSort {

    public static int[] countSort(int[] nums) {

        //1、得到数列的最大值
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
        }

        //2、根据数列最大值确定数组的长度
        int[] countArray = new int[max + 1];

        //3、遍历数列，填充统计数组
        for(int i = 0; i < nums.length; i++) {
            countArray[nums[i]]++;
        }

        //4、遍历统计数组，输出结果
        int index = 0;
        int[] sortedArray = new int[nums.length];
        for(int i = 0; i < countArray.length; i++) {
            for(int j = 0; j < countArray[i]; j++) {
                sortedArray[index++] = i;
            }
        }

        return sortedArray;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 4, 6, 5, 3, 2, 8, 1, 7, 5, 6, 0, 10};
        //int[] nums = new int[] {95, 96, 92, 93, 91, 98};

        int[] sortedArray = countSort(nums);
        System.out.println(Arrays.toString(sortedArray));
    }


}