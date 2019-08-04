package com.yangzanjie.Queue;

/**
 * @author : yangzanjie
 * create at:  2019-08-03  15:13
 * @description: 链式队列：链表实现队列
 */
public class QueueBasedLinkedList<T> {
    /**
     * 链表
     * @param <T>
     */
    class Node<T> {
        private T element;

        private Node<T> next;

        public Node() {
            this.element = null;
            this.next = null;
        }

        public Node(T element) {
            this.element = element;
            this.next = null;
        }

        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    /**
     * 头指针，出列指针
     */
    private Node head;

    /**
     * 尾指针，入列指针
     */
    private Node tail;

    public QueueBasedLinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * 入队
     * @param data
     */
    public void enqueue(T data) {
        Node node = new Node(data);
        if (tail != null) {
            tail.next = node;
        }
        tail = node;
        if (head == null) {
            head = tail;
        }
    }

    /**
     * 出队
     * @return
     */
    public Object dequeue() {
        if (head != null) {
            Node out = head;
            head = head.next;
            return out.element;
        } else {
            return null;
        }
    }

    /**
     * 打印队列所有内容
     */
    public void printAll() {
        Node pre = head;
        System.out.println("****head****");
        while(pre != null) {
            System.out.println(pre.element.toString());
            pre = pre.next;
        }
        System.out.println("****end****");
    }

    /**
     * test
     * @param args
     */
    public static void main(String[] args){
        QueueBasedLinkedList test = new QueueBasedLinkedList();
        for (int i =  0; i < 2; i++){
            test.enqueue(i);
        }

        System.out.println("After enqueue 0 : 2;");
        test.printAll();

        System.out.println("After dequeue once");
        System.out.println("dequeue out = " + test.dequeue().toString());
        test.printAll();

        System.out.println("After dequeue once");
        System.out.println("dequeue out = " + test.dequeue().toString());
        test.printAll();

        System.out.println("After enqueue once");
        System.out.println("dequeue in = " + 5);
        test.enqueue(5);
        test.printAll();
    }
}
