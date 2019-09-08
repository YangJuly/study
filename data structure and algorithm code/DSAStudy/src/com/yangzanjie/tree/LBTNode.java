package com.yangzanjie.tree;

/**
 * @author : yangzanjie
 * create at:  2019-08-18  13:04
 * @description: 链式存储的二叉树节点 LinkedBinaryTreeNode
 */
public class LBTNode<T> {
    private T data;
    private LBTNode left;
    private LBTNode right;

    public LBTNode() {
        data =null;
        left = null;
        right = null;
    }

    public LBTNode(T data, LBTNode left, LBTNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LBTNode getLeft() {
        return left;
    }

    public void setLeft(LBTNode left) {
        this.left = left;
    }

    public LBTNode getRight() {
        return right;
    }

    public void setRight(LBTNode right) {
        this.right = right;
    }
}
