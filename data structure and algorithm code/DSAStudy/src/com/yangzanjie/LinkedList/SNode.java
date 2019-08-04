package com.yangzanjie.LinkedList;

/**
 * @author : yangzanjie
 * create at:  2019-07-28  16:46
 * @description: 单向链表简单实现
 */
public class SNode<T> {

    private T element;

    private SNode<T> nextNode;

    public SNode() {
        this.nextNode = null;
    }

    public SNode(T element) {
        this.element = element;
        this.nextNode = null;
    }

    public SNode(T element, SNode<T> nextNode) {
        this.element = element;
        this.nextNode = nextNode;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public SNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(SNode<T> nextNode) {
        this.nextNode = nextNode;
    }
}
