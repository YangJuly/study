package com.demo.set;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author : yangzanjie
 * create at:  2019-12-28  12:57
 * @description:
 */
public class LFUCache {

    class Node {
        int key;
        int val;
        int freq = 1;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DoubleLinkedNodeList {
        int freq;
        Node head;
        Node tail;

        public DoubleLinkedNodeList(int freq) {
            this.freq = freq;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
        }

        public boolean isEmpty() {
            if (head.next == tail && tail.pre == head) return true;
            return false;
        }

        public Node removeLast() {
            if (!isEmpty()) {
                Node res = tail.pre;
                remove(tail.pre);
                return res;
            }
            return null;
        }

        public void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        //add after head
        public void add(Node node) {
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }
    }

    Map<Integer, Node> cacheMap;
    Map<Integer, DoubleLinkedNodeList> freqMap;

    int size = 0;
    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = cacheMap.get(key);
        if (node == null) return  -1;
        incFreq(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        Node node = cacheMap.get(key);
        if (node != null) {
            incFreq(node);
            node.val = value;
        } else {
            //add new node
            Node newNode = new Node(key, value);
            //if size arrive, delete the minFeq and the far node
            if (size == capacity) {
                size--;
                cacheMap.remove(freqMap.get(minFreq).removeLast().key);
            }

            size++;
            minFreq = 1;
            //update freqMap
            if (!freqMap.containsKey(newNode.freq)) {
                freqMap.put(newNode.freq, new DoubleLinkedNodeList(newNode.freq));
            }
            freqMap.get(newNode.freq).add(newNode);
            //update cache
            cacheMap.put(key, newNode);
        }
    }

    public void incFreq(Node node) {
        //first delete node in old freq list, process if update minFreq
        DoubleLinkedNodeList list = freqMap.get(node.freq);
        list.remove(node);
        if (minFreq == node.freq && list.isEmpty()) {
            minFreq = node.freq + 1;
        }

        //inc freq
        node.freq++;

        //update freq map
        if (!freqMap.containsKey(node.freq)) {
            freqMap.put(node.freq, new DoubleLinkedNodeList(node.freq));
        }
        freqMap.get(node.freq).add(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
