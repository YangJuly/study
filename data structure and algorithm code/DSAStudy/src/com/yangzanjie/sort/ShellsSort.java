package com.yangzanjie.sort;

/**
 * @author : yangzanjie
 * create at:  2019-08-04  14:58
 * @description: 希尔排序，插入排序的优化版
 */
public class ShellsSort {
    public void sort(int[] arr) {
        int length = arr.length;
        int interval = length / 2;
        while (interval >= 1) {
            for (int i = interval; i < length; i++) {
                int value = arr[i];
                int j = i - interval;
                for (; j >= 0; j=j-interval) {
                    if (value > arr[j]) {
                        break;
                    } else {
                        arr[j + interval] = arr[j];
                    }
                }
                arr[j+interval] = value;
            }
            interval = interval / 2;
        }
    }
}
