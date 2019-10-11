package com.yangzanjie.diversion;

/**
 * @author : yangzanjie
 * create at:  2019-10-10  15:25
 * @description: 计算一组数的逆序对
 */
public class CalReverseOrder {
    private int num  = 0;

    public int count(int[] nums, int n) {
        num = 0;
        mergeSorting(nums, 0, n-1);
        return num;
    }

    private void mergeSorting(int[] nums, int p, int r) {
        if (p >= r) return;
        int mid = r + (p - r) >> 1;
        mergeSorting(nums, p, mid);
        mergeSorting(nums, mid + 1, r);
        merge(nums, p , mid, r);
    }

    private void merge(int[] nums, int p, int mid, int r) {
        int[] temp = new int[r - p + 1];
        int j = 0;
        int left = p;
        int right = mid + 1;
        while (left <= mid && right <= r) {
            if (nums[right] < nums[left]) {
                num += mid - left + 1; //统计p-mid之间 比nums[right]大的个数
                temp[j++] = nums[right++];
            } else {
                temp[j++] = nums[left++];
            }
        }
        while (left <= mid) {
            temp[j++] = nums[left++];
        }
        while (right <= r) {
            temp[j++] = nums[right++];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[p+i] = temp[i];
        }
    }
}
