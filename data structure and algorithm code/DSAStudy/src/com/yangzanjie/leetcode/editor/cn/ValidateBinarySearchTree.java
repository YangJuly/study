//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索
  
package com.yangzanjie.leetcode.editor.cn;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ValidateBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
        TreeNode root = new ValidateBinarySearchTree().new TreeNode(1);
        root.left = new ValidateBinarySearchTree().new TreeNode(1);
//        root.right = new ValidateBinarySearchTree().new TreeNode(3);
        System.out.println(solution.isValidBST(root));

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
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double inOrder = - Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inOrder) return false;
            inOrder = root.val;
            root = root.right;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}