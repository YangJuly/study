package com.yangzanjie.sort;

/**
 * @author : yangzanjie
 * create at:  2019-08-04  14:44
 * @description: 选择排序
 */
public class SelectSort {
    public void sort(int[] arr) {
        int length =  arr.length;
        for (int i = 0; i < length; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex =  j;
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
    }
}
