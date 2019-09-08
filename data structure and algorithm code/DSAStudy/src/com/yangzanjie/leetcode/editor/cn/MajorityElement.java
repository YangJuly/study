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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MajorityElement{
    public static void main(String[] args) {
         Solution solution = new MajorityElement().new Solution();
         int[] nums = {3,2,3};
         System.out.println(solution.majorityElement(nums));
    }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    /**
     * Boyer-Moore 投票算法
     * 思想：众数记为+1，非众数记为-1，全部相加，最后值大于0
     * 遇到第一个数，记为众数候选，向后遍历，遇到相同的，+1，遇到不相同的-1，
     * 若候选票数为0时，选择当前数为众数候选
     * 时间复杂度，严格执行n次，O(n)
     * 空间复杂度，O(1)
      * @param nums
     * @return
     */
    public int majorityElementVote(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
    /**
     * 先排序，再判断重,时间复杂度O(nlogn),空间复杂度O(1)或者O(n)，得看排序算法，是否是就地算法
     * 判断重的步骤可以优化，因为必然存在众数（count > n/2），因此排序后在索引n/2处，必然是众数
      * @param nums
     * @return
     */
    public int majorityElementSort(int[] nums) {
        int max = nums.length / 2;

//        if (nums.length  == 1) return nums[0];

        Arrays.sort(nums);
//        int count = 1;
//        for(int i = 1; i < nums.length; i++) {
//            if (nums[i] == nums[i-1]) {
//                count++;
//            } else {
//                count = 1;
//            }
//            if (count > max) return nums[i];
//        }
        return nums[max];
    }


    /**
     * 哈希法 时间复杂度O(n),空间复杂度O(n)
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        //todo
        Map<Integer, Integer> map = new HashMap<>();
        int max = nums.length / 2;
        for (int i : nums) {
            if (map.containsKey(i)) {
                int count = map.get(i) + 1;
                map.put(i, count);
                if (count > max)
                    return i;
            } else {
                map.put(i, 1);
            }
        }
        return 0;
    }

    /**
     * 暴力法，时间复杂度O(n2),空间复杂度O(1)
     * @param nums
     * @return
     */
    public int majorityElementBaolifa(int[] nums) {
        int majorityCount = nums.length/2;

        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count += 1;
                }
            }

            if (count > majorityCount) {
                return num;
            }

        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}