package com.yangzanjie.sort.review2;

/**
 * @author : yangzanjie
 * create at:  2019-11-08  17:10
 * @description:
 */
public class MergeSort {
    public void sort(int[] nums) {
        int length = nums.length;
        if (length < 2) return;
        sort(nums, 0, length-1);
    }

    public void sort(int[] nums, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int index = 0;
        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                temp[index] = nums[i];
                index++;
                i++;
            } else {
                temp[index] = nums[j];
                index++;
                j++;
            }
        }
        while (i <= mid) {
            nums[index] = nums[i];
            index++;
            i++;
        }
        while (j <= end) {
            nums[index] = nums[j];
            j++;
        }
        for (int k = 0; k < temp.length; k++) {
            nums[start+k] = temp[k];
        }
        return;
    }
}
