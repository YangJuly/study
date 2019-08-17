package com.yangzanjie.search;

/**
 * @author : yangzanjie
 * create at:  2019-08-11  14:10
 * @description: 二分查找：基础，以及变形
 */
public class BinarySeach {
    /**
     * 基础的二分搜索，要求被查询数据按顺序且无重复
     * @param arr
     * @param k
     * @return
     */
    public int baseEqualSerch(int[] arr, int k) {
        int high = arr.length - 1;
        int low = 0;
        while (low <= high) {
            //这么写的好处，1、防止low+high 溢出，2、位算法，效率更高。
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找变形1，返回第一个元素值为k的。
     * @param arr
     * @param k
     * @return
     */
    public int firstEqualSearch(int[] arr, int k) {
        int high = arr.length - 1;
        int low = 0;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > k) {
                high = mid - 1;
            } else if (arr[mid] < k){
                low = mid + 1;
            } else {
                //关键是退出条件
                if (mid == 0 || arr[mid - 1] != k) return mid;
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找变形2，返回最后一个元素值为k的。
     * @param arr
     * @param k
     * @return
     */
    public int lastEqualSearch(int[] arr, int k) {
        int length = arr.length;
        int high = length - 1;
        int low = 0;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > k) {
                high = mid - 1;
            } else if (arr[mid] < k){
                low = mid + 1;
            } else {
                //关键是退出条件
                if (mid == length - 1 || arr[mid + 1] != k) return mid;
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找变形3，查询第一个大于等于k的元素
     * @param arr
     * @param k
     * @return
     */
    public int firstEqualOrBiggerSearch(int arr[], int k) {
        int length = arr.length;
        int high = length - 1;
        int low = 0;
        while(low <=  high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < k) {
                low = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] < k) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找变形4，查询最后一个小于等于k的元素
     * @param arr
     * @param k
     * @return
     */
    public int lastEqualOrSmallerSearch(int[] arr, int k) {
        int length = arr.length;
        int high = length - 1;
        int low = 0;
        while(low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] <= k) {
                if (mid == length - 1 || arr[mid + 1] > k) return mid;
                else low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}

