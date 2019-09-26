//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索
  
package com.yangzanjie.leetcode.editor.cn;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
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
//    public int maxDepth(TreeNode root) {
//        if (root == null) return 0;
//        int leftHeight = maxDepth(root.left);
//        int rightHeight = maxDepth(root.right);
//        int currentHeight = Math.max(leftHeight, rightHeight) + 1;
//        return currentHeight;
//    }
    public int maxDepth(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        if (root != null) {
            queue.add(new Pair<>(root, 1));
        }
        int depth = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            root = pair.getKey();
            if (root != null) {
                depth = Math.max(depth, pair.getValue());
                queue.add(new Pair<>(root.left, pair.getValue()+1));
                queue.add(new Pair<>(root.right, pair.getValue()+1));
            }
        }
        return depth;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}