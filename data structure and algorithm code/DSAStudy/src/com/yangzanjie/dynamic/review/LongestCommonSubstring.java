package com.yangzanjie.dynamic.review;

/**
 * @author : yangzanjie
 * create at:  2019-12-10  11:36
 * @description: 最长公共子串，只允许增加、删除，计算最长公共子串大小，动态规划实现-复习1
 */
public class LongestCommonSubstring {
    public static int calculateDistance(char[] a, int n, char[] b, int m) {
        int[][] dp = new int[n][m];
        //初始化第一行
        for (int j = 0; j < m; j++) {
            if (a[0] == b[j]) dp[0][j] = 1;
            else if (j != 0) dp[0][j] = dp[0][j-1];
            else dp[0][j] = 0;
        }

        //初始化第一列
        for (int i = 1; i < n; i++) {
            if (a[i] == b[0]) dp[i][0] = 1;
            else if (i != 0) dp[i][0] = dp[i-1][0];
            else dp[i][0] = 0;
        }

        //逐行
        for (int i =1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (a[i] == b[j]) {
                    dp[i][j] = maxValueInThreeNum(dp[i-1][j-1] + 1, dp[i][j-1], dp[i-1][j]);
                } else {
                    dp[i][j] = maxValueInThreeNum(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n-1][m-1];
    }

    public static int maxValueInThreeNum(int x, int y, int z) {
        if (x < y) x = y;
        if (x < z) x = z;
        return x;
    }

    public static void main(String[] args) {
        System.out.println(LongestCommonSubstring.calculateDistance("mitcmu".toCharArray(), 6, "mtacnu".toCharArray(), 6));
    }
}
