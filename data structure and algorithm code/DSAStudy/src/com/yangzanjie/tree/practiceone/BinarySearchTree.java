package com.yangzanjie.tree.practiceone;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author : yangzanjie
 * create at:  2019-09-18  15:58
 * @description: 复习一：实现一个二叉查找树，支持插入、删除、查找操作
 * 未支持有重复的元素
 */
public class BinarySearchTree {
    /**
     * 二叉树的节点
     */
    public class BinaryTreeNode {
        private Integer data;
        private BinaryTreeNode left;
        private BinaryTreeNode right;

        public BinaryTreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }

        public BinaryTreeNode getLeft() {
            return left;
        }

        public void setLeft(BinaryTreeNode left) {
            this.left = left;
        }

        public BinaryTreeNode getRight() {
            return right;
        }

        public void setRight(BinaryTreeNode right) {
            this.right = right;
        }
    }

    //根节点
    private BinaryTreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    /**
     * 插入
     * @param data
     */
    public void insert(int data) {
        if (root == null) {
            root = new BinaryTreeNode(data);
            return;
        }
        BinaryTreeNode pre = root;

        while (pre != null) {
            if (data > pre.data) {
                if (pre.getRight() == null) {
                    pre.setRight(new BinaryTreeNode(data));
                    return;
                }
                pre = pre.getRight();
            } else {
                if (pre.getLeft() == null) {
                    pre.setLeft(new BinaryTreeNode(data));
                    return;
                }
                pre = pre.getLeft();
            }
        }
    }

    /**
     * 查询
     * @param data
     * @return
     */
    public BinaryTreeNode find(int data) {
        BinaryTreeNode pre = root;
        while (pre != null) {
            if (pre.data == data) return pre;
            if (data > pre.data) pre = pre.getRight();
            if (data < pre.data) pre = pre.getLeft();
        }
        return null;
    }

    /**
     * 删除节点
     * @param data
     */
    public void remove(int data) {
        //指向要删除的节点
        BinaryTreeNode pre = root;
        //指向要删除的节点的父节点、
        BinaryTreeNode fNode = null;

        while (pre != null && pre.data != data) {
            fNode = pre;
            if (data > pre.data) pre = pre.getRight();
            else pre = pre.left;
        }
        //没有找到
        if (pre == null) return;

        //要删除的节点有左子节点和右子节点
        if (pre.getLeft() != null && pre.getRight() != null) {
            //寻找右子节点中的最小节点
            //表示最小节点
            BinaryTreeNode minNode = pre.getRight();
            //表示最小节点的父节点
            BinaryTreeNode minFNode = pre;
            while (minNode.getLeft() != null) {
                minFNode = minNode;
                minNode = minNode.getLeft();
            }
            //将最小节点中的值替换到需要删除的节点
            pre.data = minNode.data;
            //删除最小节点
            pre = minNode;
            fNode = minFNode;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        BinaryTreeNode child;
        if (pre.getLeft() != null) {
            child = pre.getLeft();
        } else if (pre.getRight() !=  null) {
            child = pre.getLeft();
        } else {
            child = null;
        }

        //删除的是根节点
        if (fNode == null) root = child;
        else if (fNode.getLeft() == pre) fNode.setLeft(child);
        else fNode.setRight(child);
    }

    /**
     * 前序遍历，递归实现
     * pre -> left -> right
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(BinaryTreeNode node){
        if (node == null) return;
        System.out.println(node.data);
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    /**
     * 中序遍历，递归实现
     * left -> pre -> right
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(BinaryTreeNode node) {
        if (node == null) return;
        preOrder(node.getLeft());
        System.out.println(node.data);
        preOrder(node.getRight());
    }

    /**
     * 中序遍历，迭代实现
     * 通过栈，循环实现
     */
    public void inOrderByIteration(BinaryTreeNode root) {
        if (root == null) return;
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.println(root.data);
            root = root.right;
        }
    }

    /**
     * 后序遍历，递归实现
     * left -> right -> prev
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(BinaryTreeNode node) {
        if (node == null) return;
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.println(node.data);
    }

    /**
     * 按层遍历
     */
    public void layerOrder() {
        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            System.out.println(node.data);
            if (node.getLeft() != null) queue.push(node.getLeft());
            if (node.getRight() != null) queue.push(node.getRight());
        }
    }

    /**
     * 查找某个节点的前置节点
     * 前置/前驱节点：中序遍历时，某个节点前面的节点就是前序节点
     * 中序遍历，能有序输出
     * @param data
     * @return
     */
    public BinaryTreeNode findPreNode(int data) {
        BinaryTreeNode node = find(data);
        BinaryTreeNode p = node.getLeft();
        BinaryTreeNode pp = p;
        while (p != null) {
            pp = p;
            p = p.getRight();
        }
        return pp;
    }


    /**
     * 查找某个节点的后置节点
     * 后置节点：中序遍历时，某个节点后面的节点就是前序节点
     * @param data
     * @return
     */
    public BinaryTreeNode findPostNode(int data) {
        BinaryTreeNode node = find(data);
        BinaryTreeNode p = node.getRight();
        BinaryTreeNode pp = p;
        while (p != null) {
            pp = p;
            p = p.getLeft();
        }
        return pp;
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        for (int i = 0; i < 5; i++) {
            tree.insert(i);
        }
        for (int i = 6; i < 10; i++) {
            tree.insert(i);
        }
//        tree.inOrder();
        tree.inOrderByIteration(tree.root);
//        System.out.println(tree.findPreNode(5).data);
//        System.out.println(tree.findPostNode(5).data);
//        tree.layerOrder();
    }
}
