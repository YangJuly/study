//给定一个未排序的整数数组，找出其中没有出现的最小的正整数。 
//
// 示例 1: 
//
// 输入: [1,2,0]
//输出: 3
// 
//
// 示例 2: 
//
// 输入: [3,4,-1,1]
//输出: 2
// 
//
// 示例 3: 
//
// 输入: [7,8,9,11,12]
//输出: 1
// 
//
// 说明: 
//
// 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。 
// Related Topics 数组
  
package com.yangzanjie.leetcode.editor.cn;
public class FirstMissingPositive{
    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();
        int[] nums = {2,2,2,2};
        System.out.println(solution.firstMissingPositive(nums));
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; ) {
            if (nums[i] > 0 && nums[i] <= length && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                int index = nums[i] - 1;
                swap(nums, index, i);
            } else {
                i++;
            }
        }

        int result = length + 1;
        for (int i = 0; i < length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return result;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}