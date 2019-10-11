package com.yangzanjie.backtracking;

/**
 * @author : yangzanjie
 * create at:  2019-10-10  14:41
 * @description: 0-1背包问题，回溯思想实现
 * 时间复杂度2^n，指数级
 */
public class BagProblem {

    public int maxW = Integer.MIN_VALUE; //存储背包中物品总重量的最大值
    /**
     *  假设背包可承受重量100，物品个数10个，物品重量存储在数组a中，那么可以这样调用函数
     *  f(0,0,a,10,100)
     * @param i      表示考察到第i个物品了
     * @param cw     表示当前物品重量
     * @param items  每个物品的重量
     * @param n      表示共有n个物品
     * @param w      表示背包的重量
     */
    public void f(int i, int cw, int[] items, int n, int w) {
        if (cw == w || i == n ) { // cw==w 表示装满了；i==n表示已经考察完所有的物品
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        f(i+1, cw, items, n, w);
        if (cw + items[i] <= w) { //已经超过背包可以承受的重量时，就不再装了
            f(i+1, cw + items[i], items, n, w);
        }
    }

    public int maxV = Integer.MIN_VALUE; //存储背包中物品总价格的最大值

    public void f2 (int i, int cw, int cv, int[] items, int[] values, int n, int w) {
        if (cw == w || i == n) {
            if (cv > maxV) maxV = cv;
            return;
        }
        f2( i + 1, cw, cv, items, values, n, w); //不放物品
        if (cw + items[i] <= w) { //已经超过背包可以承受的重量时，就不再装了
            f2(i+1,  cw+items[i], cv+values[i], items, values, n, w);
        }
    }
}
