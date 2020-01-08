package com.yangzanjie.interview;

/**
 * @author : yangzanjie
 * create at:  2019-11-27  17:53
 * @description: demo类
 */
public class Demo {
    public static void main(String[] args) {
        Demo d = new Demo();
        System.out.println(d.sqrt(2,2));
    }

    public double sqrt(int x, int n) {
        double accuracy = 1.0;
        for (int i = 0; i < n; i++) {
            accuracy = accuracy * 0.1;
        }
        double low = 0;
        double high = x;
        while ((high - low) > accuracy) {
            double mid = (low + high) / 2;
            if (mid * mid < x) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return (low + high) / 2;
    }


}
