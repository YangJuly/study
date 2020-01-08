package com.yangzanjie.sort;

import java.util.Random;

/**
 * @author : yangzanjie
 * create at:  2019-08-10  14:15
 * @description: 快速排序
 */
public class QuickSort {

    public void sort(int[] arr) {
        int length = arr.length;
        quickSort(arr, 0, length - 1);
        return;
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int par = partition(arr, start, end);
        quickSort(arr, start, par - 1);
        quickSort(arr, par + 1, end);
        return;
    }

    /**
     * 分区操作
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private int partition(int[] arr,  int start, int end) {
        // select a random pivot_index

        Random randomNum = new Random();
        int pivotIndex = start + randomNum.nextInt(end - start);
        swap(arr, pivotIndex, end);

        int p = arr[end];
        int i = start;
        for (int j = start; j < end; j++) {
            //如果值小于等于p，出发swap
            if (arr[j] <= p) {
              swap(arr, j, i);
              i++;
            }
        }
        swap(arr, i, end);
        return i;
    }

    /**
     * 原地交换数组中i和j的元素
     * @param arr
     * @param i
     * @param j
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        return;
    }

    //test
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        QuickSort test = new QuickSort();
        test.sort(arr);
        for (int i:arr) {
            System.out.println(i);
        }
    }

}
