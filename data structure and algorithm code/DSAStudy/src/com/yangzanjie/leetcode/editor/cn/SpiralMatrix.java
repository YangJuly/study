//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。 
//
// 示例 1: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2: 
//
// 输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
// Related Topics 数组
  
package com.yangzanjie.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix{
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        int[][] nums = {{1,2,3,4,5,6,7,8,9,10}};
        solution.spiralOrder(nums);
        System.out.println();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return res;
        int yLength = matrix[0].length;
        int xLength = matrix.length;
        int boundaryRight = yLength - 1;
        int boundaryLeft = 0;
        int boundaryDown = xLength - 1;
        int boundaryTop = 0;

        while (boundaryLeft <= boundaryRight && boundaryTop <= boundaryDown) {
            for (int i = boundaryLeft; i <= boundaryRight; i++) {
                res.add(matrix[boundaryTop][i]);
            }

            for (int j = boundaryTop+1; j <= boundaryDown; j++) {
                res.add(matrix[j][boundaryRight]);
            }

            if (boundaryLeft < boundaryRight && boundaryTop < boundaryDown) {
                for (int i = boundaryRight - 1; i > boundaryLeft; i--) {
                    res.add(matrix[boundaryDown][i]);
                }
                for (int j = boundaryDown; j > boundaryTop; j--) {
                    res.add(matrix[j][boundaryLeft]);
                }
            }
            boundaryLeft++;
            boundaryRight--;
            boundaryTop++;
            boundaryDown--;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}