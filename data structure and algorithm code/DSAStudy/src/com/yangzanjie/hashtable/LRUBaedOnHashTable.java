package com.yangzanjie.hashtable;

import java.util.HashMap;

/**
 * @author : yangzanjie
 * create at:  2019-08-11  18:09
 * @description: 基于散列表-链表实现的LRU算法
 */
public class LRUBaedOnHashTable {
    /**
     * cache容量
     */
    private int maxSize;

    private Node head;

    private Node tail;

    private HashMap<String, Node> hashMap;

    private class Node {
        private String key;
        private String value;
        private Node next;
        private Node prev;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    public LRUBaedOnHashTable(int maxSize) {
        this.maxSize = maxSize;
        this.hashMap = new HashMap<>((int) (maxSize * 1.5));
        this.head = null;
        this.tail = null;
    }

    public String get(String key) {
        if (!hashMap.containsKey(key)) return null;
        Node node = hashMap.get(key);
        deleteNode(node);
        insertFront(node);
        return node.getValue();
    }

    public void put(String key, String value) {
        if (hashMap.containsKey(key)) {
            Node node = hashMap.get(key);
            deleteNode(node);
            insertFront(node);
            return;
        }
        Node node = new Node(key, value);
        hashMap.put(key, node);
        if (hashMap.size() > this.maxSize) {
            Node tail = this.tail;
            this.tail = this.tail.prev;
            deleteNode(tail);
            hashMap.remove(tail.getKey());
        } else {
            insertFront(node);
        }
    }

    public void delete(String key) {
        if (!hashMap.containsKey(key)) return;
        Node node = hashMap.get(key);
        deleteNode(node);
        hashMap.remove(key);
        return;
    }

    private void insertFront(Node node) {
        if (node == null) return;
        node.next = this.head;
        this.head = node;
        return;
    }

    private void deleteNode(Node node) {
        if (node == null) return;
        Node temp = node;
        node.prev.next = node.next;
        temp.setNext(null);
        temp.setPrev(null);
        return;
    }
}
