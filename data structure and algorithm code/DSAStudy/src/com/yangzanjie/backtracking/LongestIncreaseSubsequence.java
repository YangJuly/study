package com.yangzanjie.backtracking;

/**
 * @author : yangzanjie
 * create at:  2019-10-10  20:25
 * @description: 最长递增子序列，回溯实现
 */
public class LongestIncreaseSubsequence {
    private int maxLength = Integer.MIN_VALUE;

    //调用lis(..., 0, 0, 1, 1);
    //fixme 更新 s i j 的方式有误
    public void lis (int[] seq, int s, int i, int j, int length) {
        if (s == seq.length - 1 || j >= seq.length) {
            if (length > maxLength) maxLength = length;
            return;
        }
        lis(seq, s+1, s+1, s+2, 1);
        if (seq[j] > seq[i]) {
            lis(seq, s, j, j+1, length+1);
        } else {
            lis(seq, s, i, j+1, length);
            lis(seq, s, j, j+1, length);
        }
    }

    public static void main(String[] args) {
        int[] seq = {2,9,3,6,5,1,7,8};
        LongestIncreaseSubsequence longestIncreaseSubsequence = new LongestIncreaseSubsequence();
        longestIncreaseSubsequence.lis(seq, 0, 0, 1, 1);
        System.out.println(longestIncreaseSubsequence.maxLength);
    }
}
