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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum{
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        int[] nums = {-1,0,1,2,-1,-4};
        solution.threeSum(nums);
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            } else {
                int left = i + 1;
                int right = length - 1;
                while (left < right && nums[right] >= 0) {
                    int temp = nums[left] + nums[right] + nums[i];
                    if (temp == 0) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        //update index
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (temp > 0) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}