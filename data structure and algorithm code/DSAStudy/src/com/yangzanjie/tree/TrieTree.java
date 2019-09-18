package com.yangzanjie.tree;

/**
 * @author : yangzanjie
 * create at:  2019-09-16  20:16
 * @description: 实现一个字符集，只包含a-z的TrieTree
 */
public class TrieTree {
    private TrieNode root = new TrieNode('/'); //存储无意义字符

    //往Trie树插入一个字符串
    public void insert(char[] text) {
        TrieNode p = root;
        for (char ch : text) {
            int index = ch - 'a';
            if (p.children[index] == null) {
                TrieNode newNode = new TrieNode(ch);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndngChar = true;
        return;
    }

    //在Trie树查询一个字符串
    public boolean find(char[] text) {
        TrieNode p = root;
        for (char ch : text) {
            int index = ch - 'a';
            if (p.children[index] == null) return false;
            p = p.children[index];
        }
        if (p.isEndngChar) return true;
        return false;
    }

    public class TrieNode {
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndngChar = false;
        public TrieNode(char data) {
            this.data = data;
        }
    }
}
