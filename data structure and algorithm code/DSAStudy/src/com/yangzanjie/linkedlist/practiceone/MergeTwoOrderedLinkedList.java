package com.yangzanjie.linkedlist.practiceone;

/**
 * @author : yangzanjie
 * create at:  2019-09-07  17:17
 * @description: 实现合并两个有序列表
 */
public class MergeTwoOrderedLinkedList {
    /**
     * 实现合并两个有序列表，默认从小到大，基于SingleLinkedList
     */
    public static SingleLinkedList mergeBasedOnSL(SingleLinkedList listOne, SingleLinkedList listTwo) {
        SingleLinkedList result = new SingleLinkedList();

        SingleLinkedList.Node nodeOne = listOne.getHead();
        SingleLinkedList.Node nodeTwo = listTwo.getHead();

        while (nodeOne != null && nodeTwo != null) {
            if (new Integer(nodeOne.getData()) <= new Integer(nodeTwo.getData())) {
                result.addTail(nodeOne.getData());
                nodeOne = nodeOne.getNextNode();
            } else {
                result.addTail(nodeTwo.getData());
                nodeTwo = nodeTwo.getNextNode();
            }
        }

        while (nodeOne != null) {
            result.addTail(nodeOne.getData());
            nodeOne = nodeOne.getNextNode();
        }

        while (nodeTwo != null) {
            result.addTail(nodeTwo.getData());
            nodeTwo = nodeTwo.getNextNode();
        }

        return result;
    }
}
