package com.yangzanjie.stack;

/**
 * @author : yangzanjie
 * create at:  2019-09-09  20:44
 * @description: 链式栈
 */
public class LinkedStack {
    /**
     * 栈的容量
     */
    private int capacity;

    /**
     * 栈当前的存储量
     */
    private int count = 0;

    private Node head;

    public LinkedStack() {
        this.capacity = 5;
        this.count = 0;
        this.head = null;
    }

    public LinkedStack(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.head = null;
    }

    public class Node {
        private String data;
        private Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    /**
     * 入栈
     * @param data
     * @return
     */
    public  boolean push(String data) {
        if (this.count >= this.capacity) return false;
        if (this.count == 0) {
            this.head = new Node(data);
            this.count++;
            return true;
        }
        Node node = this.head;
        for (int i = 0; i < this.count - 1; i++) {
            node = node.next;
        }
        node.next = new Node(data);
        this.count++;
        return true;
    }

    /**
     * 出栈
     * @return
     */
    public String poll() {
        if (this.count <= 0) return null;
        Node node = this.head;
        for (int i = 0; i < this.count - 1; i++) {
            node = node.next;
        }
        this.count--;
        return node.getData();
    }

}
