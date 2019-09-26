package com.yangzanjie.heap;

/**
 * @author : yangzanjie
 * create at:  2019-09-19  17:17
 * @description: 复习一：实现堆排序
 */
public class HeapSort {
    public static void sort(int[] nums, int n) {
        //step1 建堆，堆化
        buildHeap(nums, n);

        //step2 将堆顶元素，即最大值，交换到数组末尾，（可为删除堆顶元素），再堆化堆顶
        int k = n;
        while (k > 1) {
            swap(nums, 1 - 1, k - 1);
            --k;
            heapify(nums, k, 1);
        }
    }

    /**
     * 建堆
     * @param nums
     * @param n
     */
    public static void buildHeap(int[] nums, int n) {
        for (int i = n / 2; i >= 1; --i) {
            heapify(nums, n, i);
        }
    }

    private static void heapify(int[] nums, int n, int i) {
        while (true) {
            int maxPosi = i;
            if (i * 2 <= n && nums[maxPosi - 1] < nums[i * 2 - 1]) maxPosi = i * 2;
            if (i * 2 + 1 <= n && nums[maxPosi - 1] < nums[i * 2 + 1 - 1])  maxPosi =  i * 2 + 1;
            if (maxPosi == i) break;
            swap(nums, maxPosi - 1, i - 1);
            i = maxPosi;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,2,3,4,6,7,9,8,10};
        sort(nums, nums.length);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
