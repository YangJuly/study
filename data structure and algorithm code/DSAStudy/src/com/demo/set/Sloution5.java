package com.demo.set;

/**
 * @author : yangzanjie
 * create at:  2019-12-26  18:20
 * @description:
 */
public class Sloution5 {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while (k > 0) {
            int steps = calSteps(n, cur, cur + 1);
            if (k < steps) {
                k--;
                cur = cur * 10;
            } else {
                k = k - steps;
                cur = cur + 1;
            }
        }
        return cur;
    }

    //在范围n内，n1节点到n2节点的数量，不包括n2
    public int calSteps(int n, int n1, int n2) {
        int count = 0;
        while (n1 <= n) {
            count += Math.min(n + 1, n2) - n1;
            n1 = n1 * 10;
            n2 = n2 * 10;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(new Sloution5().findKthNumber(20, 2));
    }
}
