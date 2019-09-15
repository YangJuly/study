package com.yangzanjie.sort.review1;

/**
 * @author : yangzanjie
 * create at:  2019-09-15  15:41
 * @description: 复习一：插入排序
 */
public class InsertSort {
    public static void sort(int[] nums) {
        int length = nums.length;
        if (length <= 0) return;
        for (int i = 0; i < nums.length; i++) {
            int j = 0;
            for (; j < i; j++) {
                if (nums[j] > nums[i]) {
                    break;
                }
            }
            if (j < i) {
                int temp = nums[i];
                for (int k = j + 1; k <= i; k++) {
                    nums[k] = nums[k - 1];
                }
                nums[j] = temp;
            }
        }
        return;
    }

    // 插入排序，a 表示数组，n 表示数组大小
    public void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j+1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j+1] = value; // 插入数据
        }
    }
}
