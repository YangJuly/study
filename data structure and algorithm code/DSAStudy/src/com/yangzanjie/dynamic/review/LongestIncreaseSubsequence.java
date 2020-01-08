package com.yangzanjie.dynamic.review;

/**
 * @author : yangzanjie
 * create at:  2019-12-10  12:52
 * @description: 最长递增子序列，动态规划实现-复习1
 */
public class LongestIncreaseSubsequence {
    public static int calculateLIS(int[] nums) {
        //dp  包含当前index num的最长递增子序列
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
        }
        int result = Integer.MIN_VALUE;
        for (int i : dp) {
            if (result < i) result = i;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] seq = {2, 9, 3, 6, 5, 1, 7};
        System.out.println(LongestIncreaseSubsequence.calculateLIS(seq));
    }
}
