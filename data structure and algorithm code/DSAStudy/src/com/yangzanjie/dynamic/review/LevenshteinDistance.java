package com.yangzanjie.dynamic.review;

/**
 * @author : yangzanjie
 * create at:  2019-12-10  11:19
 * @description: 莱文斯坦编辑距离，动态规划实现，复习1
 */
public class LevenshteinDistance {
    public static int calculateDistance(char[] a, int n, char[] b, int m) {
        int[][] dp = new int[n][m];
        //初始化第一行
        for (int i = 0; i < m; i++) {
            if (a[0] == b[i]) dp[0][i] = i;
            else if (i != 0) dp[0][i] = dp[0][i-1];
            else dp[0][i] = 1;
        }
        //初始化第一列
        for (int j = 1; j < n; j++) {
            if (a[j] == b[0]) dp[j][0] = j;
            else if (j != 0) dp[j][0] = dp[j-1][0] + 1;
            else dp[j][0]  = 1;
        }
        //逐行计算
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (a[i] == b[j]) {
//                    dp[i][j] = dp[i-1][j-1];
                    dp[i][j] = minValInThreeNum(dp[i-1][j] + 1, dp[i][j-1] + 1, dp[i-1][j-1]);
                } else {
                    dp[i][j] = minValInThreeNum(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1;
                }
            }
        }

        return dp[n-1][m-1];
    }

    public static int minValInThreeNum(int x, int y, int z) {
        if (x > y) {
            x = y;
        }
        if (x > z) {
            x = z;
        }
        return x;
    }

    public static void main(String[] args) {
        com.yangzanjie.dynamic.LevenshteinDistance levenshteinDistance = new com.yangzanjie.dynamic.LevenshteinDistance();
        System.out.println(levenshteinDistance.lwstDP("mitcmu".toCharArray(), 6, "mtacnu".toCharArray(), 6));
    }
}
