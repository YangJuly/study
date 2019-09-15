package com.yangzanjie.recursive;

/**
 * @author : yangzanjie
 * create at:  2019-09-14  11:52
 * @description: 递归实现斐波那契数列
 */
public class FibonacciSequence {
    public static int solution(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        return solution(n - 1) + solution(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(solution(1));
        System.out.println(solution(2));

        System.out.println(solution(11));
    }
}
