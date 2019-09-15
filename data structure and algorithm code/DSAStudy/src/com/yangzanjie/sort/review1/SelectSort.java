package com.yangzanjie.sort.review1;

/**
 * @author : yangzanjie
 * create at:  2019-09-15  15:39
 * @description: 复习一：选择排序
 */
public class SelectSort {
    public static void sort(int[] nums) {
        int length = nums.length;
        if (length <= 0) return;
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++)  {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
        return;
    }
}
