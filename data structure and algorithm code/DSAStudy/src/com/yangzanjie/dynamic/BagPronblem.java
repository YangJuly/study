package com.yangzanjie.dynamic;

/**
 * @author : yangzanjie
 * create at:  2019-10-10  16:47
 * @description: 0-1背包问题，动态规划实现
 *
 * 时间复杂度 o（n*w）
 */
public class BagPronblem {
    /**
     *
     * @param weight  记录物品重量的数组
     * @param n       物品个数
     * @param w       背包能承受的重量
     * @return
     */
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w+1]; //默认值false
        states[0][0] = true;                      //第一行数据处理下
        if (weight[0] <= w) {
            states[0][weight[0]] = true;
        }
        for (int i = 1; i < n; i++) { //动态规划状态转移
            for (int j = 0; j <= w; j++) { //不把第i个物品放入背包中
                if (states[i-1][j] == true) states[i][j] = true;
            }
            for (int j = 0; j <= w - weight[i]; j++) { //把第i个物品放入背包中
                if (states[i-1][j] == true) states[i][j+weight[i]] = true;
            }
        }
        for (int i = w; i >= 0; i--) { //输出结果
            if (states[n-1][i] == true) return i;
        }
        return 0;
    }


    //改进，额外存储空间只用一个一维数组
    public int knapsack2(int[] weight, int n, int w) {
        boolean[] states = new boolean[w+1];
        states[0] = true;
        if (weight[0] <= w) {
            states[weight[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = w - weight[i]; j >= 0; j--) {
                if (states[j] == true) states[j + weight[i]] = true;
            }
        }
        for (int i = w; i >= 0; i--) {
            if (states[i] == true) return i;
        }
        return 0;
    }

    //0-1背包，进化版，每个=物品有价格，求能装下的物品的最大价格

    /**
     *
     * @param weight
     * @param values 表示物品的价格
     * @param n
     * @param w
     * @return
     */
    public int knapsack3(int[] weight, int[] values, int n, int w) {
        int[][] states = new int[n][w+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        if (weight[0] <= w) {
            states[0][weight[0]] = values[0];
        }
        for (int i = 1; i < n; i++) { //动态规划
            for (int j = 0; j < w; j++) { //不选择第i个物品
                if (states[i-1][j] >= 0) states[i][j] = states[i-1][j];
            }
            for (int j = 0; j <= w - weight[i]; j++) { //选择第i个物品
                if (states[i-1][j] > 0) {
                    int v = states[i-1][j] + values[i];
                    if (v > states[i][j+weight[i]]) {
                        states[i][j+weight[i]] = v;
                    }
                }
            }
        }
        int maxValue = -1;
        for (int j = 0; j < w + 1; j++) {
            if (states[n-1][j] > maxValue) maxValue = states[n-1][j];
        }
        return maxValue;
    }
}
