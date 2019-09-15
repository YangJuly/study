package com.yangzanjie.search.review1;

/**
 * @author : yangzanjie
 * create at:  2019-09-15  16:59
 * @description: 复习一：有序数组的二分查找算法
 */
public class BinarySearch {
    public static Integer baseSerach(int[] nums, int target) {
        /**
        int length = nums.length;
        int start = 0;
        int end = length - 1;
        int mid = start + (end - start) / 2; //防止整数溢出
        while(nums[mid] != target) {
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = start + (end - start) / 2; //防止整数溢出
        }
        return mid;
         **/
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return null;
    }

    public static Integer firstEqualSearch(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == k) {
                if (mid == 0 || nums[mid - 1] != k) return mid;
                else high = mid - 1;
            } else if (nums[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }

    public static Integer lastEqualSearch(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == k) {
                if (mid == nums.length - 1 ||  nums[mid + 1] != k) return mid;
                else low = mid + 1;
            } else if (nums[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }

    public static Integer firstEqualOrBiggerSearch(int[] nums,  int k) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] >= k) {
                if (mid == 0 || nums[mid - 1] < k) return mid;
                else high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }

    public static Integer lastEqualOrSmallerSearch(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] <= k) {
                if (mid == nums.length - 1 ||  nums[mid + 1] > k) return mid;
                else low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,5,6,7,8,9,10};
//        System.out.println(baseSerach(nums,2));
//        System.out.println(baseSerach(nums,10));
//        System.out.println(baseSerach(nums,1));
//        System.out.println(baseSerach(nums,5));


        int[] numsTwo = {1,2,3,4,4,4,4,5,6,7,8,9,10};
        System.out.println(lastEqualOrSmallerSearch(numsTwo,2));

    }
}
