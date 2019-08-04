package com.yangzanjie.sort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author : yangzanjie
 * create at:  2019-08-04  14:17
 * @description: 测试排序算法
 */
public class SortTest {
    public static void main(String[] args) throws
            ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException,
            IllegalAccessException,
            InstantiationException {
        int[] arr = {9, 8, 7, 6, 3, 5, 4, 1, 2, 0};

        Class bubbleSort = Class.forName("com.yangzanjie.sort.BubbleSort");
//        Method sort = bubbleSort.getMethod("sort", int[].class);
//        sort.invoke(bubbleSort.getConstructor().newInstance(), arr);

        Class selectSort = SelectSort.class;
//        Method sort = selectSort.getMethod("sort", int[].class);
//        sort.invoke(selectSort.getConstructor().newInstance(), arr);

        Class shellsSort = ShellsSort.class;
        Method sort = shellsSort.getMethod("sort", int[].class);
        sort.invoke(shellsSort.getConstructor().newInstance(), arr);

        for (int i:arr) {
            System.out.println(i);
        }
    }
}
