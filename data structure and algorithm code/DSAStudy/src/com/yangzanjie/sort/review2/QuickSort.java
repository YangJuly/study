package com.yangzanjie.sort.review2;

/**
 * @author : yangzanjie
 * create at:  2019-12-04  16:45
 * @description: 快速排序-复习
 */
public class QuickSort {
    public static void sort(int[] nums) {
        int length = nums.length;
        sort(nums, 0, length-1);
    }

    private static void sort(int[] nums, int start, int end) {
        if (start >= end) return;
        int par = partition(nums, start, end);
        sort(nums, 0, par - 1);
        sort(nums, par, end);
    }

    private static int partition(int[] nums, int start, int end) {
        int i = start;
        int pivot = nums[end];
        for (int j = start; j < end; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, end);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }

    //test
    public static void main(String[] args) {
        int[] arr = {6,7,6};
        QuickSort test = new QuickSort();
        test.sort(arr);
        for (int i:arr) {
            System.out.println(i);
        }
    }
}
