package com;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : yangzanjie
 * create at:  2019-12-26  14:59
 * @description: test
 */
public class Demo {

    public int solve(int n, int m, int[] input) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = Integer.MAX_VALUE;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (input[i] == 0) {
                //清空map 移动start
                map = new HashMap<>();
                start = i + 1;
                continue;
            }

            //记录当前击中气球
            if (map.containsKey(input[i])) {
                map.put(input[i], map.get(input[i]) + 1);
            } else {
                map.put(input[i], 1);
            }

            //已经命中所有颜色
            if (map.size() == m) {
                //移动指针start，获取最小length
                while (map.get(input[start]) > 1) {
                    start++;
                    map.put(input[start], map.get(input[start]) - 1);
                }
                res = Math.min(res, i - start + 1);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    //test
    public static void main(String[] args) {
        int[] input = {2,5,3,1,3,2,4,1,0,5,4,3};
        System.out.println(new Demo().solve(12, 5, input));
    }
}
