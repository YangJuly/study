//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
// Related Topics 树
  
package com.yangzanjie.leetcode.editor.cn;

import javafx.util.Pair;

import java.util.*;

public class LowestCommonAncestorOfABinaryTree{
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
        TreeNode root = new LowestCommonAncestorOfABinaryTree().new TreeNode(1);
        TreeNode two = new LowestCommonAncestorOfABinaryTree().new TreeNode(2);
        TreeNode three = new LowestCommonAncestorOfABinaryTree().new TreeNode(3);
        TreeNode four = new LowestCommonAncestorOfABinaryTree().new TreeNode(4);
        TreeNode five = new LowestCommonAncestorOfABinaryTree().new TreeNode(5);
        TreeNode six = new LowestCommonAncestorOfABinaryTree().new TreeNode(6);
        TreeNode seven = new LowestCommonAncestorOfABinaryTree().new TreeNode(7);
        TreeNode eight = new LowestCommonAncestorOfABinaryTree().new TreeNode(8);
        TreeNode nine = new LowestCommonAncestorOfABinaryTree().new TreeNode(9);

        root.left = two;
        root.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        four.left = eight;
        four.right = nine;
        solution.lowestCommonAncestor(root, five, eight);
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        queue.add(root);
        parent.put(root, null);
        while (!(parent.containsKey(p) && parent.containsKey(q))) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                parent.put(node.left, node);
            }
            if (node.right != null) {
                queue.add(node.right);
                parent.put(node.right, node);
            }
        }

        Set<TreeNode> pParentSet = new HashSet<>();
        while (p != null) {
            pParentSet.add(p);
            p = parent.get(p);
        }

        while (!pParentSet.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}