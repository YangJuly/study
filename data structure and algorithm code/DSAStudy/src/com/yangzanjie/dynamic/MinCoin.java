package com.yangzanjie.dynamic;

/**
 * @author : yangzanjie
 * create at:  2019-12-10  10:14
 * @description: 硬币找零问题
 */
public class MinCoin {
    public int calculateMinCoin(int[] coins, int money) {
        int[] state = new int[money + 1];

        for (int i = 1; i < state.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j : coins) {
                if (i == j) {
                    state[i] = 1;
                    min = 0;
                    break;
                } else if (j > i) {
                    break;
                } else {
                    min = Math.min(min, state[i - j]);
                }
            }
            if (min > 0 && min < Integer.MAX_VALUE) state[i] = min + 1;
        }
        return state[money];
    }

    public static void main(String[] args) {
        int[] coins = {1,3,5};
        System.out.println(new MinCoin().calculateMinCoin(coins, 10));
    }
}
