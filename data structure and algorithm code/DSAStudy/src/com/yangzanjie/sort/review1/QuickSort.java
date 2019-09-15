package com.yangzanjie.sort.review1;

/**
 * @author : yangzanjie
 * create at:  2019-09-15  16:01
 * @description: 复习一：快速排序
 */
public class QuickSort {
    public static void sort(int[] nums) {
        int length = nums.length;
        if (length <= 0)  return;
        quickSort(nums, 0, length - 1);
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int p = partition(nums, start, end);
        quickSort(nums, start, p - 1);
        quickSort(nums, p, end);
        return;
    }

    public static int partition(int[] nums, int start, int end) {
        int value = nums[end];
        int i = start;
        int j = start;
        while (i < end) {
            if (nums[i] <= value) {
                if (i != j) swap(nums, i, j);
                j++;
            }
            i++;
        }
        swap(nums, end, j);
        return j;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }
}
