package com.yangzanjie.linkedlist.practiceone;

/**
 * @author : yangzanjie
 * create at:  2019-09-07  16:00
 * @description: 实现单链表，支持增删操作
 * 操作：增加一个头结点，删除头结点，增加尾结点，删除尾结点
 */
public class SingleLinkedList {
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

    public SingleLinkedList() {
        this.head = null;
    }

    /**
     * 增加头结点
     * @param data
     */
    public void addHead(String data) {
        Node node = new Node(data);
        Node oldHead = this.head;
        this.head = node;
        node.nextNode = oldHead;
    }

    /**
     * 删除头结点
     */
    public void deleteHead() {
        if (this.head == null) return;
        this.head = this.head.nextNode;
    }

    /**
     * 增加尾结点
     */
    public void addTail(String data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
            return;
        }
        Node node = this.head;
        while(node.nextNode != null) {
            node = node.nextNode;
        }
        node.nextNode = newNode;
        return;
    }

    /**
     * 删除尾结点
     */
    public void deleteTail() {
        if (this.head == null) return;
        if (this.head.nextNode == null) {
            this.head = null;
            return;
        }
        Node node = this.head;
        while(node.nextNode.nextNode != null) {
            node = node.nextNode;
        }
        node.nextNode = null;
        return;
    }

    /**
     * 打印整个链表
     */
    public void printAll() {
        Node node = this.head;
        System.out.println("\n**************start************");
        while (node != null) {
            System.out.print(node.getData() + " -> ");
            node = node.nextNode;
        }
        System.out.println("\n**************end************\n");
    }

    public Node getHead() {
        return head;
    }

    /**
     * 实现求链表的中间结点
     * 若链表为1，则返回的中间结点为1，
     * 若1-2，则返回1；
     * 若1-2-3，则返回2；
     * @return
     */
    public String getMiddle() {
        if (this.head == null) return null;
        if (this.head.nextNode == null) return this.head.getData();

        Node lowNode = this.head;
        Node fastNode = this.head;

        while (fastNode.getNextNode() != null && fastNode.getNextNode().getNextNode() != null)  {
            lowNode = lowNode.nextNode;
            fastNode = fastNode.getNextNode().getNextNode();
        }
        return lowNode.getData();
    }
}
