package com.yangzanjie.sort.review1;

/**
 * @author : yangzanjie
 * create at:  2019-09-15  16:35
 * @description: 实现O(n)复杂度里查询第k大元素
 */
public class FindKMax {
    public static int finndKMax(int[] nums, int k) {
        int length =  nums.length;
        int[] numsCopy = new int[length];
        for (int i = 0; i < length; i++) {
            numsCopy[i] = nums[i];
        }
        int start = 0;
        int end = length - 1;
        k=k-1;
        while(true) {
            int index = partition(numsCopy, start, end);
            if (index == k) {
                return numsCopy[index];
            } else if (index > k) {
                end = index - 1;
            } else {
                start = index;
            }
        }
    }

    public static int partition(int[] nums, int start, int end) {
        int i = start;
        int j = start;
        while(i < end) {
            if (nums[i] <= nums[end]) {
                if (i != j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                j++;
            }
            i++;
        }
        int temp = nums[end];
        nums[end] = nums[j];
        nums[j] = temp;
        return j;
    }
}
