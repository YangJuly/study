package com.yangzanjie.recursive;

/**
 * @author : yangzanjie
 * create at:  2019-09-14  12:19
 * @description: 递归实现阶乘
 */
public class Factorial {

    public static int solution(int n) {
        if (n == 1) return 1;
        return n * solution(n-1);
    }

    public static void main(String[] args) {
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(10)); //362880
    }
}
