//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
// 
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。 
// Related Topics 树 深度优先搜索
  
package com.yangzanjie.leetcode.editor.cn;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class PathSum{
    public static void main(String[] args) {
        Solution solution = new PathSum().new Solution();
        TreeNode treeNode2 = new PathSum().new TreeNode(2);
        TreeNode treeNode1 = new PathSum().new TreeNode(1);

        treeNode1.left = treeNode2;

        System.out.println(solution.hasPathSum(treeNode1, 1));

    }
    

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

   public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.right == null && root.left == null) {
            if (sum - root.val == 0) return true;
            else return false;
        } else {
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}