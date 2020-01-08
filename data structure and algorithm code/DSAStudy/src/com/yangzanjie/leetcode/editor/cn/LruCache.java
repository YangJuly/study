//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计
  
package com.yangzanjie.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache{
    public static void main(String[] args) {

    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    class DataNode {
        int key;
        int value;
        DataNode prev;
        DataNode next;
    }

    private void moveToHead(DataNode dataNode) {
        removeNode(dataNode);
        insertHead(dataNode);
    }

    private DataNode popTail() {
        DataNode temp = tail.prev;
        removeNode(temp);
        return temp;
    }

    private void removeNode(DataNode dataNode) {
        DataNode pre = dataNode.prev;
        DataNode next = dataNode.next;
        pre.next = next;
        next.prev = pre;
    }

    private void insertHead(DataNode dataNode) {
        dataNode.next = head.next;
        dataNode.prev = head;

        head.next.prev = dataNode;
        head.next = dataNode;
    }

    private DataNode head;
    private DataNode tail;
    private int capacity;
    private int size;

    private Map<Integer, DataNode> data = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DataNode();
        tail = new DataNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DataNode dataNode = data.get(key);
        if (dataNode == null) return -1;
        moveToHead(dataNode);
        return dataNode.value;
    }

    public void put(int key, int value) {
        DataNode dataNode = data.get(key);
        if (dataNode != null) {
            dataNode.value = value;
            moveToHead(dataNode);
        } else {
            DataNode node = new DataNode();
            node.key = key;
            node.value = value;

            insertHead(node);
            data.put(key, node);

            size++;

            if (size > capacity) {
                DataNode tail = popTail();
                data.remove(tail.key);
                size--;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}