package com.yangzanjie.linkedlist.practiceone;

/**
 * @author : yangzanjie
 * create at:  2019-09-07  16:46
 * @description: 实现循环链表，支持增删操作
 */
public class CircleLinkedList {
    /**
     * 定义链表结点
     */
    class Node {
        private String data;

        private Node nextNode;

        public Node(String data) {
            this.data = data;
            this.nextNode = null;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }

    /**
     * 头部节点
     */
    private Node head;

    public CircleLinkedList() {
        this.head = null;
    }

    /**
     * 往循环链表头部，插入一个数据
     * @param data
     */
    public void addHead(String data) {
        if (this.head == null) {
            addFirstNode(data);
            return;
        }
        Node node = this.head;
        while (node.nextNode != this.head) {
            node = node.nextNode;
        }
        Node temp = this.head;
        this.head = new Node(data);
        this.head.nextNode = temp;
        node.nextNode = this.head;
        return;
    }

    /**
     * 删除循环链表的头结点
     */
    public void deleteHead() {
        if (this.head == null) return;
        if (this.head.nextNode == this.head) {
            this.head = null;
            return;
        }
        Node node = this.head;
        while (node.nextNode != this.head) {
            node = node.nextNode;
        }
        this.head = this.head.nextNode;
        node.nextNode = this.head;
        return;
    }

    /**
     * 当循环链表为空时，添加第一个元素
     * @param data
     */
    private void addFirstNode(String data) {
        this.head = new Node(data);
        this.head.nextNode = this.head;
        return;
    }
    /**
     * 往循环链表尾部，插入一个数据，
     * @param data
     */
    public void addTail(String data) {
        if (this.head == null) {
            addFirstNode(data);
            return;
        }
        Node node = this.head;
        while(node.nextNode != this.head) {
            node = node.nextNode;
        }
        node.nextNode = new Node(data);
        node.nextNode.nextNode = this.head;
        return;
    }

    /**
     * 删除循环链表尾部的一个数据
     */
    public void deleteTail() {
        if (this.head == null) return;
        if (this.head.nextNode == this.head) {
            this.head = null;
            return;
        }
        Node node = this.head;
        while(node.nextNode.nextNode != this.head) {
            node = node.nextNode;
        }
        node.nextNode = this.head;
        return;
    }

    public void printAll() {
        if (this.head == null) return;

        System.out.println("\n**************start****************");

        Node node = this.head;
        System.out.print(node.getData() + " -> ");
        while (node.nextNode != this.head) {
            System.out.print(node.nextNode.getData() + " -> ");
            node = node.nextNode;
        }
        System.out.println("\n**************end****************\n\n");
        return;
    }
}
