package com.yangzanjie.hashtable;

/**
 * @author : yangzanjie
 * create at:  2019-09-15  19:25
 * @description: 基于链表法解决冲突问题的散列表
 */
public class HashTable {
    class Node {
        private String key;
        private String value;
        private Node next;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 初始容量
     */
    private int capacity = 8;

    private Node[] array;

    public HashTable() {
        this.array = new Node[this.capacity];
    }

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.array = new Node[capacity];
    }

    public void put(String key, String value) {
        if (key == null) return;
        int hashValue = hash(key);
        int index = hashValue % this.capacity;
        if (array[index] == null) {
            array[index] = new Node(key, value);
        } else {
            Node node = array[index];
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(key, value);
        }
        return;
    }

    public String getValue(String key) {
        if (key == null) return null;
        int hashValue = hash(key);
        int index = hashValue % this.capacity;
        Node node = array[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            } else {
                node = node.next;
            }
        }
        return null;
    }

    /**
     * 计算key的哈希值
     * 取字符串长度和开头第一个字符的ascii值的乘积
     * @param key
     * @return
     */
    public int hash(String key) {
        if (key.length() == 0) return 0;
        int value = key.charAt(0);
        int hashcode = key.length() * value;
        if (hashcode < 0) hashcode = hashcode + Integer.MAX_VALUE;
        return hashcode;
    }

}
