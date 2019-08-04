package com.yangzanjie.sort;

/**
 * @author : yangzanjie
 * create at:  2019-08-04  13:51
 * @description: 冒泡排序
 */
public class BubbleSort {
    /**
     *
     * @param arr
     */
    public void sort(int[]  arr) {
        int length =  arr.length;
        //冒泡n次
        for (int i = 0; i < length; i++) {
            //是否有数据交换发生
            boolean flag = true;
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j + 1];
                    arr[j+1] =  arr[j];
                    arr[j] = temp;
                    flag =  false;
                }
            }
            if(flag) {
//                System.out.println("break in step " + i);
                break;
            }
        }
    }
}
