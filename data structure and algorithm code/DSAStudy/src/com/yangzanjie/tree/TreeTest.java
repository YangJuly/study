package com.yangzanjie.tree;

/**
 * @author : yangzanjie
 * create at:  2019-08-18  13:21
 * @description: 二叉树测试类
 */
public class TreeTest {
    public static void main(String[] args) {
        LBTNode<Integer> node5 = new LBTNode<>(5, null, null);
        LBTNode<Integer> node4 = new LBTNode<>(4, null, null);
        LBTNode<Integer> node3 = new LBTNode<>(3, null, null);
        LBTNode<Integer> node2 = new LBTNode<>(2, null, null);
        LBTNode<Integer> node1 = new LBTNode<>(1, null, null);
        LBTNode<Integer> node6 = new LBTNode<>(6, null, null);
        LBTNode<Integer> node7 = new LBTNode<>(7, null, null);
        LBTNode<Integer> node8 = new LBTNode<>(8, null, null);
        LBTNode<Integer> node9 = new LBTNode<>(9, null, null);

        node5.setLeft(node4);
        node5.setRight(node8);
        node4.setLeft(node2);
        node2.setLeft(node1);
        node2.setRight(node3);
        node8.setLeft(node7);
        node7.setLeft(node6);
        node8.setRight(node9);

        LBTNode node = node5;

//        TraversalTree.preOrder(node);
        TraversalTree.inOrder(node);
//        TraversalTree.postOrder(node);
//        TraversalTree.layerOrder(node);
//        int height = TraversalTree.getMaxHeightBasedRecursive(node);
//        System.out.println(height);
    }
}
