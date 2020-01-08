//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划
  
package com.yangzanjie.leetcode.editor.cn;

import java.util.Arrays;

public class MaximumSubarray{
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        return mergeCount(nums, 0, nums.length - 1)[2];
    }

    private int[] mergeCount(int[] nums, int leftIndex, int rightIndex) {
        int[] result = new int[4];
        if (rightIndex > leftIndex) {
            int midIndex = leftIndex + ((rightIndex - leftIndex) >> 1);
            int[] resL = mergeCount(nums, leftIndex, midIndex);
            int[] resR = mergeCount(nums, midIndex + 1, rightIndex);
            result[0] = Math.max(resL[0], resL[3] + resR[0]);
            result[1] = Math.max(resR[1], resR[3] + resL[1]);
            result[2] = Math.max(Math.max(resL[2], resR[2]), resL[1] + resR[0]);
            result[3] = resL[3] + resR[3];
            return result;
        }
        Arrays.fill(result, nums[leftIndex]);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}