package com.yangzanjie.sort;

/**
 * @author : yangzanjie
 * create at:  2019-08-04  14:06
 * @description: 插入排序
 */
public class InsertionSort {
    /**
     * 插入排序
     * @param arr
     */
    public static void sort(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (value > arr[j]) {
                    break;
                } else {
                    arr[j+1] = arr[j];
                }
            }
            arr[j+1] = value;
        }
    }
}
