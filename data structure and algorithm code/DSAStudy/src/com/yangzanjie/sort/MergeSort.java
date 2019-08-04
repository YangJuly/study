package com.yangzanjie.sort;

/**
 * @author : yangzanjie
 * create at:  2019-08-04  17:56
 * @description: 归并排序
 */
public class MergeSort {
    public void sort (int[] arr) {
        int length = arr.length;
        mergeSort(arr, 0, length-1);
    }

    /**
     * 划分,二分法
     * @param arr
     * @param start
     * @param end
     */
    private void mergeSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        mergeWithGurad(arr, start, mid, end);
    }

    /**
     * 归并，不用哨兵
     * @param arr
     * @param start
     * @param mid
     * @param end
     */
    private void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int startOne = start;
        int endOne = mid;
        int startTwo = mid + 1;
        int endTwo = end;

        int i = 0;

        while(startOne <= endOne && startTwo <= endTwo) {
            if (arr[startOne] <= arr[startTwo]) {
                temp[i++] = arr[startOne++];
            } else {
                temp[i++] = arr[startTwo++];
            }
        }

        int s = startOne;
        int e = endOne;
        if (startTwo <= endTwo) {
            s = startTwo;
            e = endTwo;
        }
        while (s <= e) {
            temp[i++] = arr[s++];
        }

        for (int j : temp) {
            arr[start++] = j;
        }

        return;
    }


    /**
     * 归并，有哨兵
     * @param arr
     * @param start
     * @param mid
     * @param end
     */
    private void mergeWithGurad(int[] arr, int start, int mid, int end) {
        int[] left = new int[mid - start + 2];
        int[] right  = new int[end - mid  + 1];

        //添加哨兵
        left[mid - start + 1] = Integer.MAX_VALUE;
        right[end - mid] = Integer.MAX_VALUE;

        int i = 0;
        for(int j = start; j <= mid; j++) {
            left[i++] = arr[j];
        }

        i=0;
        for(int j = mid+1; j <= end; j++) {
            right[i++] = arr[j];
        }

        i = 0;
        int j = 0;
        while(start <= end) {
            if (left[i] <=  right[j]) {
                arr[start++] = left[i++];
            } else {
                arr[start++] = right[j++];
            }
        }

        return;
    }

    /**
     * test
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        MergeSort m = new MergeSort();
        m.sort(arr);

        for(int i : arr) {
            System.out.println(i);
        }
    }
}
