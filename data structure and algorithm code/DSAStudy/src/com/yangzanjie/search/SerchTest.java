package com.yangzanjie.search;

import com.yangzanjie.sort.SortTest;

/**
 * @author : yangzanjie
 * create at:  2019-08-11  14:25
 * @description: 查询方法的测试类
 */
public class SerchTest {
    public static void main(String[] args) {
        BinarySeach binarySeachTest = new BinarySeach();
        int[] arr1 = {0,1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySeachTest.baseEqualSerch(arr1, 5));

        int[] arr2 = {0,1,2,3,4,4,4,5,6,7,8,9,10};
        System.out.println(binarySeachTest.firstEqualSearch(arr2, 4));

        int[] arr3 = {0,1,2,3,4,4,4,5,6,7,8,9,10};
        System.out.println(binarySeachTest.lastEqualSearch(arr3, 4));

        int[] arr4 = {0,1,2,3,4,4,4,6,7,8,9,10};
        System.out.println(binarySeachTest.firstEqualOrBiggerSearch(arr4, 5));

        int[] arr5 = {0,1,2,3,4,4,4,6,7,8,9,10};
        System.out.println(binarySeachTest.lastEqualOrSmallerSearch(arr5, 5));
    }
}
