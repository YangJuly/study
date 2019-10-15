//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划
  
package com.yangzanjie.leetcode.editor.cn;

import java.util.List;

public class Triangle{
    public static void main(String[] args) {
        Solution solution = new Triangle().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] path = new int[triangle.size()];
        path[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) { //行
            for (int j = i; j >= 0; j--) { //列
                int min = Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    min = Math.min(min, path[j-1]);
                }
                if (j <= i - 1) {
                    min = Math.min(min, path[j]);
                }
                path[j] = min + triangle.get(i).get(j);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < path.length; i++) {
            if (path[i] < min) {
                min = path[i];
            }
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}