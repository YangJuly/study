package com.yangzanjie.dynamic;

/**
 * @author : yangzanjie
 * create at:  2019-10-10  20:13
 * @description: 最长公共子串，动态规划实现
 */
public class LongestCommonSubstring {
    //todo
    public int lcs(char[] a, int n, char[] b, int m) {
        int[][] maxLength = new int[n][m];
        if (a[0] == b[0]) {
            maxLength[0][0] = 1;
        } else {
            maxLength[0][0] = 0;
        }
        for (int i = 1; i < m; i++) { //初始化第0行, a[0..0]与b[0...i]
            if (a[0] == b[i]) maxLength[0][i] = 1;
            else maxLength[0][i] = maxLength[0][i-1];
        }
        for (int i = 1; i < n; i++) { //初始化第0列，a[0..i]与b[0..0]
            if (a[i] == b[0]) maxLength[i][0] = 1;
            else maxLength[i][0] = maxLength[i-1][0];
        }
        for (int i = 1; i < n; i++) { //逐行填充
            for (int j = 1; j < m; j++) {
                if (a[i] == a[j]) {
                    maxLength[i][j] = max(maxLength[i-1][j-1] + 1, maxLength[i-1][j], maxLength[i][j-1]);
                } else {
                    maxLength[i][j] = max(maxLength[i-1][j-1], maxLength[i-1][j], maxLength[i][j-1]);
                }
            }
        }
        return maxLength[n-1][m-1];
    }

    public int max(int x, int y, int z) {
        int maxv = Integer.MIN_VALUE;
        if (x > maxv) maxv = x;
        if (y > maxv) maxv = y;
        if (z > maxv) maxv = z;
        return maxv;
    }
}
