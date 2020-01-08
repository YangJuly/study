//给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。 
//
// 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。 
//
// 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。 
//
// 示例 1: 
//
// 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//输出: [1,2],[1,4],[1,6]
//解释: 返回序列中的前 3 对数：
//     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// 
//
// 示例 2: 
//
// 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//输出: [1,1],[1,1]
//解释: 返回序列中的前 2 对数：
//     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// 
//
// 示例 3: 
//
// 输入: nums1 = [1,2], nums2 = [3], k = 3 
//输出: [1,3],[2,3]
//解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
// 
// Related Topics 堆
  
package com.yangzanjie.leetcode.editor.cn;

import java.util.*;

public class FindKPairsWithSmallestSums{
    public static void main(String[] args) {
        Solution solution = new FindKPairsWithSmallestSums().new Solution();
        int[] nums1 = {1,1,2};
        int[] nums2 = {1,2,3};
        List<List<Integer>> res = solution.kSmallestPairs(nums1, nums2, 100);
        System.out.println();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            return (nums1[o1[0]] + nums2[o1[1]]) - (nums1[o2[0]] + nums2[o2[1]]);
        });

        if (nums1.length == 0 || nums2.length == 0) return res;

        for (int i = 0; i < nums1.length; i++) {
            int[] record = {i, 0};
            queue.add(record);
        }

        while (k > 0 && !queue.isEmpty()) {
            int[] min = queue.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[min[0]]);
            list.add(nums2[min[1]]);
            res.add(list);
            k--;
            if (min[1] + 1 < nums2.length) {
                int[] record = {min[0], min[1] + 1};
                queue.add(record);
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}