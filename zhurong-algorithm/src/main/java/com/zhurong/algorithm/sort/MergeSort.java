/**   
 * @Title: MergeSort.java
 * @Package: com.zhurong.algorithm.sort
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.algorithm.sort;

import java.util.Arrays;

/**
 * @description: 归并排序。时间复杂度O（n logn）
 * @author LZG
 * @date 2019/3/11
 */
public class MergeSort {

    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            a[k2 + low] = temp[k2];
        }
    }

    public static void mergeSort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            mergeSort(a, low, mid);
            // 右边
            mergeSort(a, mid + 1, high);
            // 左右归并
            merge(a, low, mid, high);

            System.out.println(Arrays.toString(a));
        }

    }

    public static void main(String[] args) {
        int a[] = {50, 10, 20, 5, 55, 3, 77, 60};

        System.out.println(Arrays.toString(a) + "--原来");
        mergeSort(a, 0, a.length - 1);
    }

}