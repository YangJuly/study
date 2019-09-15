package com.yangzanjie.sort.review1;

/**
 * @author : yangzanjie
 * create at:  2019-09-15  15:17
 * @description: 复习一：冒泡排序
 */
public class BubbleSort {
    public static void sort(int[] nums) {
        int length  = nums.length;
        if (length<=0) return;

        for (int i = 0; i < length; i++) {
            boolean isSwap = false;
            for (int j = 0; j < length - i - 1; j++)  {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    isSwap = true;
                }
            }
            if (isSwap == false) {
                return;
            }
        }
        return;
    }
}
