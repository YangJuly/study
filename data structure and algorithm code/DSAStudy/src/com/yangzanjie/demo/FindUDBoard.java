package com.yangzanjie.demo;

import java.util.Arrays;

/**
 * @author : yangzanjie
 * create at:  2019-12-12  15:17
 * @description: 有序数组 A = [1, 2, 2, 3, 3, 5, 5, 5]，b = 5，在A中找出b的序号的上下界，考察思路和代码熟练度
 */
public class FindUDBoard {
    public static int[] search(int[] nums, int b) {
        int left = 0;
        int right = nums.length - 1;

        int leftBoard = 0;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] > b) {
                right = mid - 1;
            } else if (nums[mid] < b) {
                left = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] != b) {
                    leftBoard = mid;
                    break;
                } else {
                    right = mid - 1;
                }
            }
        }

        int rightBoard = 0;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] > b) {
                right = mid - 1;
            } else if (nums[mid] < b) {
                left = mid + 1;
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] != b) {
                    rightBoard = mid;
                    break;
                } else {
                    left = mid + 1;
                }
            }
        }

        int[] res = new int[2];
        res[0] = leftBoard;
        res[1] = rightBoard;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 5, 5, 5};
        int[] res = search(nums, 5);
        System.out.println(res[0] + "  " + res[1]);
    }
}
