package com.yangzanjie.tree;

import com.yangzanjie.queue.QueueBasedLinkedList;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : yangzanjie
 * create at:  2019-08-18  13:01
 * @description: 二叉树的遍历，前中后序，按层遍历，求解最大高度
 */
public class TraversalTree {

    /**
     * 前序遍历，递归方式
     * @param node
     */
    public static void preOrder(LBTNode node) {

        if (node == null) return;
        //step1 当前节点
        System.out.println(node.getData());
        //step2 左子节点
        preOrder(node.getLeft());
        //step3 右子节点
        preOrder(node.getRight());
    }

    /**
     * 中序遍历，递归方式
     * @param node
     */
    public static void inOrder(LBTNode node) {
        if (node == null) return;

        //step1 左子节点
        inOrder(node.getLeft());
        //step2 当前结点
        System.out.println(node.getData());
        //step3 右子节点
        inOrder(node.getRight());
    }

    /**
     * 后序遍历，递归方式
     * @param node
     */
    public static void postOrder(LBTNode node) {
        if (node == null) return;

        //step1 左子节点
        postOrder(node.getLeft());
        //step2 右子节点
        postOrder(node.getRight());
        //step3 当前结点
        System.out.println(node.getData());
    }

    /**
     * 按层遍历
     * @param node
     */
    public static void layerOrder(LBTNode node) {
        if (node == null) return;

        Queue<LBTNode> queue = new LinkedList<>();

        queue.add(node);
        while (!queue.isEmpty()) {
            LBTNode currentNode = queue.poll();
            System.out.println(currentNode.getData());
            if (currentNode.getLeft() != null) {
                queue.add(currentNode.getLeft());
            }
            if (currentNode.getRight() != null) {
                queue.add(currentNode.getRight());
            }
        }
        return;
    }

    /**
     * 递归法，深度优先，求树最大高度
     * 当前结点高度=max(左子树高度,右子树高度)+1
     * 高度从0开始计
     * @param node
     * @return
     */
    public static int getMaxHeightBasedRecursive(LBTNode node) {
        if (node == null) return 0;
        int leftTreeHeight = getMaxHeightBasedRecursive(node.getLeft());
        int rightTreeHeight = getMaxHeightBasedRecursive(node.getRight());
        int currentTreeHeight = Math.max(leftTreeHeight, rightTreeHeight) + 1;
        return currentTreeHeight - 1;
    }

    /**
     * 按层遍历法，求树最大高度
     * @param node
     * @return
     */
    public static int getMaxHeightBasedLayer(LBTNode node) {
        //todo
        return 0;
    }
}
