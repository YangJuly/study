package com.yangzanjie.demo;

/**
 * @author : yangzanjie
 * create at:  2019-12-17  17:04
 * @description:
 */
public class InnerClassTest {
    public static void main(String[] args) {
        System.out.println(new Inner().add());
        System.out.println(new Inner().add());
    }

    public static class Inner {
        private static int count = 0;
        private int add() {
            return ++count;
        }
    }
}
