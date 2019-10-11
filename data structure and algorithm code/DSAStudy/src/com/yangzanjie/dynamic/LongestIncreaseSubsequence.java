package com.yangzanjie.dynamic;

/**
 * @author : yangzanjie
 * create at:  2019-10-10  20:22
 * @description: 最长递增子序列，动态规划实现
 */
public class LongestIncreaseSubsequence {
    public int lis(int[] nums) {
        int[] maxLength = new int[nums.length];
        maxLength[0] = 1;
        for (int i = 1; i < maxLength.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (maxLength[j] > max) max = maxLength[j];
                }
                maxLength[i] = max + 1;
            }
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < maxLength.length; i++) {
            if (maxLength[i] > result) result = maxLength[i];
        }
        return result;
    }


    public static void main(String[] args) {
        int[] seq = {2,9,3,6,5,1,7};
        LongestIncreaseSubsequence longestIncreaseSubsequence = new LongestIncreaseSubsequence();
        System.out.println(longestIncreaseSubsequence.lis(seq));
    }
}
