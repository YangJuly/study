package com.yangzanjie.hashtable;

/**
 * @author : yangzanjie
 * create at:  2019-09-15  19:56
 * @description: 哈希表的验证类
 */
public class HashTableTest {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.put("test", "test-value");
        System.out.println(hashTable.getValue("test"));
    }
}
