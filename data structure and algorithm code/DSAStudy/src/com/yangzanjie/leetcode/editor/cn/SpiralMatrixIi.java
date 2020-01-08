//给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。 
//
// 示例: 
//
// 输入: 3
//输出:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//] 
// Related Topics 数组
  
package com.yangzanjie.leetcode.editor.cn;
public class SpiralMatrixIi{
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        solution.generateMatrix(3);
        System.out.println();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 1;
        int rs = n - 1;
        int cs = n - 1;
        int r = 0;
        int c = 0;
        while (r <= rs && c <= cs) {
            for (int j = c; j <= cs; j++) {
                res[r][j] = count;
                count++;
            }
            for (int i = r + 1; i <= rs; i++) {
                res[i][cs] = count;
                count++;
            }
            for (int j = cs - 1; j > n - cs - 1; j--) {
                res[rs][j] = count;
                count++;
            }
            for (int i = rs; i > n - rs - 1; i--) {
                res[i][c] = count;
                count++;
            }
            r++;
            c++;
            rs--;
            cs--;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}