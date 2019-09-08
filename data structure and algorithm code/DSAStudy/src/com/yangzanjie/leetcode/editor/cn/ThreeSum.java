//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针
  
package com.yangzanjie.leetcode.editor.cn;

import java.util.*;

public class ThreeSum{
    public static void main(String[] args) {
         Solution solution = new ThreeSum().new Solution();
         int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> result = solution.threeSum(nums);
        for (List<Integer> r : result) {
            System.out.println();
            for (Integer i : r) {
                System.out.print(i + " -> ");
            }
            System.out.println();
        }
    }
      

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            int length = nums.length;
            if (length < 3) return result;
            Arrays.sort(nums);  //排序
            for (int i = 0; i < length - 2; i++) {
                //直接退出
                if (nums[i] > 0) {
                    break;
                }
                //去重
                if (i  > 0 && nums[i] == nums[i-1]) {
                    continue;
                }
                int left  = i + 1;
                int right = length - 1;
                while (right > left) {
                    int r = nums[i] + nums[left] + nums[right];
                    if (r == 0) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (right > left && nums[left] == nums[left + 1]) left++;  //左指针去重
                        while (right > left && nums[right] == nums[right - 1]) right--; //右指针去重
                        left++;
                        right--;
                    }
                    if (r > 0) {
                        right--;
                    }
                    if (r < 0) {
                        left++;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}