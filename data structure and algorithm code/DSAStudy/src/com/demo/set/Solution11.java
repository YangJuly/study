package com.demo.set;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author : yangzanjie
 * create at:  2019-12-29  18:28
 * @description:
 */
public class Solution11 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new LinkedList<>();
        preOrder(1, n, res);
        return res;
    }

    //pre order
    public void preOrder(int i, int n, List<Integer> res) {
        if (i > n) return;
        //process cur
        res.add(i);
        //process next node in next layer
        if (i * 10 <= n) preOrder(i * 10, n, res);
        //process next node in same layer
        //layer less than 10
        int max = (i / 10 + 1) * 10;
        if (i + 1 < max) preOrder(i + 1, n, res);

        return;
    }

    public static void main(String[] args) {
        List<Integer> res = new Solution11().lexicalOrder(13);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
