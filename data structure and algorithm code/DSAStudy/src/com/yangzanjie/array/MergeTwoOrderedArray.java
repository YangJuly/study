package com.yangzanjie.array;

/**
 * @author : yangzanjie
 * create at:  2019-09-07  15:45
 * @description: 实现合并两个有序数组，顺序默认从小到大
 */
public class MergeTwoOrderedArray {
    public static int[] merge (int[] arrayOne, int[] arrayTwo) {
        int lengthOne = arrayOne.length;
        int lengthTwo = arrayTwo.length;
        int[] result = new int[lengthOne + lengthTwo];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < lengthOne && j < lengthTwo) {
            if (arrayOne[i] <= arrayTwo[j]) {
                result[k++] = arrayOne[i++];
            } else {
                result[k++] = arrayTwo[j++];
            }
        }

        while (i < lengthOne) {
            result[k++] = arrayOne[i++];
        }

        while (j < lengthTwo) {
            result[k++] = arrayTwo[j++];
        }
        return result;
    }
}
