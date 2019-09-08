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
         int[] nums = {3,4,-1,1};
         System.out.println(solution.firstMissingPositive(nums));
    }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 思想：长度为n的数组，可能缺失的正数x在区间[1,n+1]里，
     * 将可能值x放入索引index为x-1处，
     * 在最后遍历时，若nums[index] != index+1，则缺失该index+1；
     * 若遍历下来全部齐全，未缺失，则缺失值为n+1。
      * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;

//        for (int i = 0; i < length; i ++) {
//            //注意这个while循环，当swap后，当前位置上的值，还需要再次判断，是否放到了正确的位置上，
//            //要一直循环，直至，满足条件
//            while (nums[i] > 0 && nums[i] <= length && nums[nums[i] - 1] != nums[i]) {
//                int temp = nums[nums[i] - 1];
//                nums[nums[i] - 1] = nums[i];
//                nums[i] = temp;
//            }
//        }
        int j = 0;
        while (j < length) {
            int index = nums[j];
            if (index > 0 && index <= length && nums[index - 1] != index) {
                int temp = nums[index - 1];
                nums[index - 1] = index;
                nums[j] = temp;
            } else {
                j++;
            }
        }

        for (int i = 0; i < length; i ++) {
            if (nums[i] != i + 1)
                return i+1;
        }
        return length + 1;
    }
    /**
     * 索引法
     * @param nums
     * @return
     */
    public int firstMissingPositiveIndex(int[] nums) {
        int length = nums.length;

        int contains = 0;
        for (int i : nums) {
            if (i == 1) contains = 1;
        }

        //step1 确认1是否存在，如果不存在，则缺失的正数一定是1
        if (contains == 0) return 1;

        //step2 如果1存在，且长度只有1，则缺失的正数一定是2
        if (length == 1) return 2;

        //step3 负数和大于n的数字，全部设置为1
        for (int i = 0; i < length; i++) {
            if (nums[i] <= 0 || nums[i] > length) {
                nums[i] = 1;
            }
        }

        for (int i = 0; i < length; i++) {
            int index = Math.abs(nums[i]);
            if (index == length) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[index] = -Math.abs(nums[index]);
            }
        }

        for (int i = 1; i < length; i++) {
            if (nums[i] > 0) return i;
        }

        if (nums[0] > 0) {
            return length;
        }

        return length + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}