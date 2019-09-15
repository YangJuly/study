package com.yangzanjie.queue;

/**
 * @author : yangzanjie
 * create at:  2019-09-14  11:04
 * @description: 基于单链表实现的链式队列（长度有限的队列）
 */
public class LinkedQueue {
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

    /**
     * 尾部节点
     */
    private Node tail;

    /**
     * 队列容量
     */
    private int capacity;

    /**
     * 队列长度
     */
    private int count = 0;

    public LinkedQueue(int capacity) {
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
    }

    /**
     * 入队
     * @param data
     * @return
     */
    public boolean enqueue(String data) {
        if (count >= capacity) return false;
        if (tail == null) {
            tail = new Node(data);
            head = tail;
            count++;
            return true;
        }
        tail.nextNode = new Node(data);
        tail = tail.nextNode;
        count++;
        return true;
    }

    /**
     * 出队
     * @return
     */
    public String dequeue() {
        if (count <= 0)
            return null;
        String result = head.data;
        head = head.nextNode;
        count--;
        if (head == null) {
            tail = null;
        }
        return result;
    }
}
