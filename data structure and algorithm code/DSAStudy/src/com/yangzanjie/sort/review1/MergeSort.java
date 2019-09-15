package com.yangzanjie.sort.review1;

/**
 * @author : yangzanjie
 * create at:  2019-09-15  16:00
 * @description: 复习一：归并排序
 */
public class MergeSort {
    public static void sort(int[] nums) {
        int length = nums.length;
        if (length <= 0) return;
        mergeSort(nums, 0, length - 1);
    }

    public static void mergeSort(int[] nums, int start, int end) {
        if (end <= end) return;
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
        return;
    }

    public static void merge(int[] nums, int start, int mid, int end) {
        int[] temps = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j  <= end) {
            if (nums[i] <= nums[j]) {
                temps[k] = nums[i];
                k++;
                i++;
            } else {
                temps[k] = nums[j];
                j++;
                k++;
            }
        }
        while(i <= mid) {
            temps[k] = nums[i];
            k++;
            i++;
        }
        while( j <= end) {
            temps[k] = nums[j];
            k++;
            j++;
        }

        for (int n = 0; n < temps.length; n++) {
            nums[start + n] = temps[n];
        }
        return;
    }
}
