package com.yangzanjie.dynamic;

/**
 * @author : yangzanjie
 * create at:  2019-10-10  19:44
 * @description: 莱文斯坦编辑距离，动态规划实现
 */
public class LevenshteinDistance {
    public int lwstDP(char[] a, int n, char[] b, int m) {
        int[][] minDist = new int[n][m];

        for (int j = 0; j < m; j++) { //初始化第0行: a[0..0]与b[0..j]的距离
            if (a[0] == b[j]) minDist[0][j] = j;
            else if (j != 0) minDist[0][j] = minDist[0][j-1] + 1;
            else minDist[0][j] = 1;
        }

        for (int i = 0; i < n; i ++) { //初始化第0列，a[0..i]与b[0..0]的距离
            if (a[i] == b[0]) minDist[i][0] = i;
            else if (i != 0) minDist[i][0] = minDist[i-1][0] + 1;
            else minDist[i][0] = 1;
        }

        for (int i = 1; i < n; i++) { //按行填表
            for (int j = 1; j < m; j++) {
                if (a[i] == b[j]) {
                    minDist[i][j] = min(
                            minDist[i-1][j] + 1, minDist[i][j-1] + 1, minDist[i-1][j-1]);
                } else {
                    minDist[i][j] = min(
                            minDist[i-1][j] + 1, minDist[i][j-1] + 1, minDist[i-1][j-1] + 1);
                }

            }
        }

        return minDist[n-1][m-1];
    }

    private int min(int x, int y, int z) {
        int minV = Integer.MAX_VALUE;
        if (x < minV) minV = x;
        if (y < minV) minV = y;
        if (z < minV) minV = z;
        return minV;
    }

    public static void main(String[] args) {
        LevenshteinDistance levenshteinDistance = new LevenshteinDistance();
        System.out.println(levenshteinDistance.lwstDP("mitcmu".toCharArray(), 6, "mtacnu".toCharArray(), 6));
    }
}
