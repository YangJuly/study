package com.yangzanjie;

import java.util.Map;
import java.util.Scanner;

/**
 * @author : yangzanjie
 * create at:  2019-12-17  18:10
 * @description:
 */
public class Demo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] A = new long[N];
        long[] B = new long[N];
        long[] C = new long[N];
        // 输入数据
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
            B[i] = sc.nextLong();
            C[i] = sc.nextLong();
        }
        for (int i = 0; i < N; i++) {
            System.out.println(solve(A[i], B[i], C[i]));
        }
    }

    public static long solve(long a,  long b, long c) {
        long[] d = ex_gcd(a, b);
        // 如果c 大于 a和b 亦或是c%d不为0，则代表不可能实现
        if (c > a && c > b || c%d[0]!=0) {
            return 0;
        } else if (c == a || c == b) {
            return 1;
        } else {
            long x = d[1];
            long y = d[2];
            if (d[2] > 0) {
                long temp2 = x;
                x = y;
                y = temp2;
                long temp = a;
                a = b;
                b = temp;
            }
            // 使ax + by = c （d是c的因子，即对上面式子ax + by = d两边同时乘以c / d）
            long a2 = a/d[0];
            long b2 = b/d[0];
            x *= c/d[0];
            y *= c/d[0];

            /* 最小化|x|+|y|
             *  ax+by=c的全部整数解为：
             *           x+kb/gcd(a,b)
             *           y−ka/gcd(a,b),      k=...,−2,−1,0,1,2,...
             * */

            long k = x/b2;
            x -= k*b2;// 使这组(x, y)最接近0（x > 0时的整数解）
            y += k*a2;
            long res ;
            if (c>a){
                res = 2*(x-y);
            }else {
                res = 2*(x-y-1);
            }
            x -= b2;// 使这组(x, y)最接近0（y > 0时的整数解）
            y += a2;
            if (c>b){
                res = Math.min(res,2*(y-x)); // 假设x > 0，这里y > 0
            }else {
                res = Math.min(res,2*(y-x-1));
            }
            return res;
        }
    }

    /**
     * 扩展欧里几何
     * 存在整数对 x，y ，使得 gcd（a，b）=ax+by
     *
     * @param a
     * @param b
     * @return 第一个值是最大公约数，第二个值x，第三个值y。
     */
    public static long[] ex_gcd(long a, long b) {
        long ans;
        long[] result = new long[3];
        if (b == 0) {
            result[0] = a;
            result[1] = 1;//x
            result[2] = 0;//y
            return result;
        }
        long[] temp = ex_gcd(b, a % b);
        ans = temp[0];//ans 相当于t
        result[0] = ans;
        result[1] = temp[2];
        result[2] = temp[1] - (a / b) * temp[2];
        return result;
    }

}
