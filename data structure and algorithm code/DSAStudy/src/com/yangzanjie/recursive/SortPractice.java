package com.yangzanjie.recursive;

import com.yangzanjie.sort.SortTest;
import com.yangzanjie.sort.review1.FindKMax;
import com.yangzanjie.sort.review1.SelectSort;

/**
 * @author : yangzanjie
 * create at:  2019-09-14  12:25
 * @description: 递归实现数据集合的全排列
 */
public class SortPractice {
    /**
     * 快速排序
     * @param nums
     */
    public void qucikSort(int[] nums) {
        int length =  nums.length;
        qucikSortImpl(nums, 0, length-1);
        return;
    }

    private void qucikSortImpl(int[] nums, int start, int end) {
        if (start >= end) return;
        int n =  partition(nums, start, end);
        qucikSortImpl(nums, start, n-1);
        qucikSortImpl(nums, n, end);
        return;
    }

    private int partition(int[] nums, int start, int end) {
        int value = nums[end];
        int j = start;
        for (int i =  start; i  < end; i++) {
//           if (nums[i] <= value) {
//               swap(nums, i, j);
//               j++;
//           }
            //判断条件一定要加上=号
            if (nums[i] <= value) {
                //优化，减少交换操作
                if (i == j) {
                    j++;
                } else {
                    swap(nums, i,  j);
                    j++;
                }
            }
        }
        swap(nums, end, j);
        return j;
    }

    /**
     * 交换数组里的两个值
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] =  nums[j];
        nums[j] = temp;
        return;
    }

    /**
     * 归并排序
     * @param nums
     */
    public void mergeSort(int[] nums) {
        int length = nums.length;
        mergeSortImpl(nums, 0 ,length - 1);
    }

    private void mergeSortImpl(int[] nums,  int start, int  end) {
        if (start >= end) return;

        int mid = (end + start) / 2;

        mergeSortImpl(nums, start, mid);
        mergeSortImpl(nums,  mid+1, end);
        merge(nums, start, mid, end);
        return;
    }

    private void merge(int[] nums, int start, int mid, int end) {
        //开辟临时数组
        int[] result = new int[end-start+1];
        int k = 0;
        int i = start;
        int j = mid + 1;
        while(i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                result[k] = nums[i];
                k++;
                i++;
            } else {
                result[k] = nums[j];
                k++;
                j++;
            }
        }
        while (i <= mid) {
            result[k] = nums[i];
            i++;
            k++;
        }
        while (j <= end) {
            result[k] = nums[j];
            k++;
            j++;
        }

        for (int integer : result) {
            nums[start++] = integer;
        }

        return;
    }

    public static void main(String[] args) {
        SortPractice sortPractice = new SortPractice();
        int[] nums = SortTest.generate(0, 10000, 1000);
//        int[] nums = {19, 80, 11, 78, 42, 36, 20, 7, 80, 7};
        SortTest.printArr(nums);

        System.out.println(FindKMax.finndKMax(nums, 2));

        System.out.println(SortTest.checkArrAsc(nums));
        sortPractice.mergeSort(nums);
//        SelectSort.sort(nums);
        System.out.println(SortTest.checkArrAsc(nums));
        SortTest.printArr(nums);
    }
}
