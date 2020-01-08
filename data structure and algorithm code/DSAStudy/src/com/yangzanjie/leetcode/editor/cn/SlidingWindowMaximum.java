//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
// Related Topics 堆 Sliding Window
  
package com.yangzanjie.leetcode.editor.cn;

import javafx.util.Pair;

import java.util.ArrayDeque;

public class SlidingWindowMaximum{
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] res = solution.maxSlidingWindow(nums, 3);
        System.out.println();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length <= 1) return nums;

        int[] result = new int[nums.length - k + 1];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        int maxLeft = Integer.MIN_VALUE;
        int maxRight = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxLeft) maxLeft = nums[i];
            left[i] = maxLeft;
            if ((i+1) % k == 0) {
                maxLeft = Integer.MIN_VALUE;
            }

            if (nums[nums.length-i-1] > maxRight) maxRight = nums[nums.length - i - 1];
            right[nums.length - i - 1] = maxRight;

            if ((nums.length - i - 1) % k == 0) {
                maxRight = Integer.MIN_VALUE;
            }
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = Math.max(left[i+k-1], right[i]);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}