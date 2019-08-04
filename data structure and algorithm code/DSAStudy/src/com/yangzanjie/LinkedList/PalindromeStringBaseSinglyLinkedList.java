package com.yangzanjie.LinkedList;

/**
 * @author : yangzanjie
 * create at:  2019-07-28  16:45
 * @description: 通过单链表存储的字符串，判断是否为回文，重构
 */
public class PalindromeStringBaseSinglyLinkedList {
    public static boolean isPalindrome(SNode node) {
        //step 1 通过快慢指针，找到中点
        //sttp 2 同时，将前半段链表反向，因为前半段会遍历走一遍，正好反个向
        SNode slowNode = node;
        SNode fastNode = node;
        SNode prevNode = null;

        if (node == null || fastNode.getNextNode() == null) {
            return true;
        }

        while (fastNode !=  null &&  fastNode.getNextNode() != null) {
            fastNode = fastNode.getNextNode().getNextNode();
            //这边的替换下
            SNode temp = slowNode.getNextNode();
            slowNode.setNextNode(prevNode);
            prevNode = slowNode;
            slowNode = temp;
        }

        //这里主要考虑到了奇数偶数长度的情况
        if (fastNode != null) {
            slowNode = slowNode.getNextNode();
        }

        while (slowNode != null) {
            if (! slowNode.getElement().equals(prevNode.getElement())) {
                return false;
            }
            slowNode = slowNode.getNextNode();
            prevNode = prevNode.getNextNode();
        }
        return true;
    }

    public static void main(String[] args) {
        SNode node = new SNode(1);
        System.out.println(isPalindrome(node));

        node.setNextNode(new SNode(2));
        System.out.println(isPalindrome(node));

        node.setNextNode(new SNode(1));
        System.out.println(isPalindrome(node));
    }
}
