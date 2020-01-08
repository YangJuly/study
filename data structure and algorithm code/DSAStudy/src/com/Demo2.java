package com;

/**
 * @author : yangzanjie
 * create at:  2019-12-31  15:34
 * @description:
 */


/**
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a contiguous subarray of which the sum ≥ s.
 * If there isn't one, return 0 instead. Input: s = 7, nums = [2,3,1,2,4,3] Output: 2 
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 */
public class Demo2 {
    public int solve(int[] nums, int s) {
        int n = nums.length;

        //sum
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum < s) return 0;

        int left = 0;
        int right = n-1;

        while (left < right) {
            if (nums[left] > nums[right]) {
                if (sum - nums[left] >= s) {
                    sum -= nums[left];
                    left++;
                }
                else break;
            } else {
                if (sum - nums[right] >= s) {
                    sum -= nums[right];
                    right--;
                }
                else break;
            }
        }
        return right - left + 1;
    }
}
