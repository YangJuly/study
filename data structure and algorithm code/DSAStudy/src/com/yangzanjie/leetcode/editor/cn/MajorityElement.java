//给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在众数。 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法
  
package com.yangzanjie.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement{
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
        int[] nums = {3,2,3};
        System.out.println(solution.majorityElement(nums));
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
//            if (candidate == nums[i]) {
//                count++;
//            } else {
//                count--;
//            }
            candidate += candidate == nums[i] ? 1 : -1;
        }
        return candidate;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}