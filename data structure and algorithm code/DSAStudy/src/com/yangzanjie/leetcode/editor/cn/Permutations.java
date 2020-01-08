//给定一个没有重复数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法
  
package com.yangzanjie.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Permutations{
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        int[] nums = {0,1,2,3};
        solution.permute(nums);
        System.out.println();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        backtrack(nums, result, visited, temp);
        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, boolean[] visited, List<Integer> temp) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            temp.add(nums[i]);
            backtrack(nums, result, visited, temp);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}