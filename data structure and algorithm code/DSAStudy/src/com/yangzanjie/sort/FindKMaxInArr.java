package com.yangzanjie.sort;

/**
 * @author : yangzanjie
 * create at:  2019-08-11  10:47
 * @description: On复杂度，在数组中查询第K大的值
 */
public class FindKMaxInArr {

    public int find(int[] arr, int k) {
        int end = arr.length - 1;
        if (k > end) {
            //fixme 这里应该抛出异常
            System.out.println("K > length, please check!");
        }
        return find(arr, 0, end, k-1);
    }

    private int find(int[] arr, int start, int end, int k) {
        int i = partition(arr, start, end);
        if (i == k)  {
            return k;
        } else if (i > k) {
            return find(arr, start, i-1, k);
        } else {
            return find(arr, i, end, k);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, end);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp =  arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        FindKMaxInArr test = new FindKMaxInArr();
        int[] arr = {9,8,7,6,5,1,2,3,4,0};
        System.out.println(test.find(arr, 5));
    }
}
