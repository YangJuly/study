package com.yangzanjie.LinkedList;

/**
 * @author : yangzanjie
 * create at:  2019-07-28  12:31
 * @description: LRUBaseLinkedList
 */
public class LRUBaseLinkedList<T> {
    /**
     * 默认容量 10
     */
    private final static Integer DEFAULT_CAPACITY = 10;

    /**
     * 头结点
     */
    private SNode<T> headNode;

    /**
     * 当前长度
     */
    private Integer length;

    /**
     * 容量
     */
    private Integer capacity;

    public LRUBaseLinkedList(Integer capacity) {
        this.headNode = new SNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public LRUBaseLinkedList() {
        this.headNode = new SNode<>();
        this.length = 0;
        this.capacity = DEFAULT_CAPACITY;
    }

    /**
     * 链表头部插入结点
     *
     * @param data
     */
    private void insertElementHead(T data) {
        SNode temp = this.headNode;
        this.headNode = new SNode<T>(data);
        this.headNode.setNextNode(temp);
        this.length++;
    }

    /**
     * 链表尾部删除结点
     *
     * @param
     */
    private void deleteElementEnd() {
        SNode node = this.headNode;
        for (int i = 1; i < this.length; i++) {
            node = node.getNextNode();
        }
        node.setNextNode(null);
        this.length--;
    }

    /**
     * 删除结点的下一个结点
     * @param node
     */
    private void deleteNextNode(SNode node) {
        SNode temp = node.getNextNode();
        node.setNextNode(temp.getNextNode());
        temp = null;
        this.length--;
    }

    /**
     * 查找元素为data的上一个结点
     *
     * @param data
     */
    private SNode findPreNode(T data) {
        SNode node = this.headNode;
        while (node.getNextNode() != null) {
            if (data.equals(node.getNextNode().getElement())) {
                return node;
            }
            node = node.getNextNode();
        }
        return null;
    }

    private boolean isHeadNode(T data) {
        if (data.equals(this.headNode.getElement())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 添加数据
     *
     * @param data
     */
    public void add(T data) {
        SNode preNode = findPreNode(data);
        if (preNode != null) {
            //删除原结点
            deleteNextNode(preNode);
            //头部插入结点
            insertElementHead(data);
        } else if (isHeadNode(data)) {
            //首结点相等，不做处理
        } else {
            if (this.length < this.capacity) {
                //如果还未满，直接头部插入结点
                insertElementHead(data);
            } else {
                //如果满了，尾部结点删除
                deleteElementEnd();
                //再在头部插入结点
                insertElementHead(data);
            }
        }
        return;
    }

    /**
     * 打印所有内容
     */
    public void printAll() {
        SNode node = this.headNode;
        while(node.getNextNode() != null) {
            System.out.println(node.getElement().toString());
            node = node.getNextNode();
        }
        System.out.println("************************");
    }

    /**
     * @author : yangzanjie
     * create at:  2019-07-28  12:31
     * @description: 单向链表
     */
    class SNode<T> {
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

    public static void main(String[] args) {
        // test LRUBaseLinkedList
        LRUBaseLinkedList lruTest = new LRUBaseLinkedList(3);
        lruTest.add(1);
        lruTest.add(2);
        lruTest.add(3);
        lruTest.printAll();

        lruTest.add(1);
        lruTest.printAll();

        lruTest.add(1);
        lruTest.printAll();

        lruTest.add(3);
        lruTest.printAll();

        lruTest.add(5);
        lruTest.printAll();
    }
}

