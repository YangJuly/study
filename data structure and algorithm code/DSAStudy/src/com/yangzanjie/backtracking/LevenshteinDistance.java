package com.yangzanjie.backtracking;

/**
 * @author : yangzanjie
 * create at:  2019-10-10  19:23
 * @description: 莱文斯坦编辑距离，回溯方法实现
 */
public class LevenshteinDistance {
    private char[] a = "mitcmu".toCharArray();
    private char[] b = "mtacnu".toCharArray();

    private int n = 6;
    private int m = 6;

    private int minDist = Integer.MAX_VALUE;

    //调用方式 lwsBT(0, 0, 0)
    public void lwsBT(int i, int j, int edist) {
        if (i == n || j == m) {
            if (i < n) edist += n - i;
            if (j < m) edist += m - j;
            if (edist < minDist) minDist = edist;
            return;
        }
        if (a[i] == b[j]) {    //两个字符匹配
            lwsBT(i+1, j+1, edist);
        } else {               //两个字符不匹配
            lwsBT(i+1, j, edist + 1); //删除a[i]或者b[j]前添加一个字符
            lwsBT(i, j+1, edist + 1); //删除b[j]或者a[i]前面添加一个字符
            lwsBT(i+1, j+1, edist + 1); //替换a[i]或者b[j]为相同字符
        }
    }
    public static void main(String[] args) {
        LevenshteinDistance levenshteinDistance = new LevenshteinDistance();
        levenshteinDistance.lwsBT(0,0,0);
        System.out.println(levenshteinDistance.minDist);
    }
}
