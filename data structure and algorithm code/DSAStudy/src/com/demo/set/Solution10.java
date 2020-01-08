package com.demo.set;

import java.util.PriorityQueue;

/**
 * @author : yangzanjie
 * create at:  2019-12-28  14:36
 * @description:
 */
public class Solution10 {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        double low = 0.0;
        double high = 1.0;
        while (true) {
            double mid = (low + high) / 2;

            //cal count which num < mid
            int count = 0;
            double max = 0;
            int[] res = new int[2];
            for (int i = 0; i < A.length; i++) {
                for (int j = A.length - 1;  j > i; j--) {
                    double temp = (double) A[i] / A[j];
                    if (temp <= mid) {
                        count++;
                        if (temp > max) {
                            max = temp;
                            res[0] = A[i];
                            res[1] = A[j];
                        }
                    } else {
                        break;
                    }
                }
            }
            if (count == K) {
                return res;
            }  else if (count < K) {
                low = mid;
            } else {
                high = mid;
            }
        }
    }
    public static void main(String[] args) {
        int[] A = {1,2,3,5};
        System.out.println(new Solution10().kthSmallestPrimeFraction(A, 3));
    }
}
