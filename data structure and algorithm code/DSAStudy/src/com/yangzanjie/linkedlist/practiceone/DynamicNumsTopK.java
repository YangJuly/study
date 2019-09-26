package com.yangzanjie.linkedlist.practiceone;

import com.yangzanjie.sort.QuickSort;
import com.yangzanjie.sort.SortTest;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @author : yangzanjie
 * create at:  2019-09-20  10:47
 * @description: 复习一：求一组动态数据集合的最大TopK
 */
public class DynamicNumsTopK {
    private int topK;

    private PriorityQueue<Integer> priorityQueue;

    public DynamicNumsTopK(int topK) {
        this.topK = topK;
        this.priorityQueue = new PriorityQueue<>(topK);
    }

    public void insert(int value) {
        if (priorityQueue.size() < topK) {
            priorityQueue.add(value);
        } else {
            if (priorityQueue.peek() < value) {
                priorityQueue.poll();
                priorityQueue.add(value);
            }
        }
    }

    public void printAll() {
        Iterator<Integer> integerIterator = priorityQueue.iterator();
        while (integerIterator.hasNext()) {
            System.out.println(integerIterator.next());
        }
    }

    public static void main(String[] args) {
        int[] nums = SortTest.generate(0, 10000, 1000);
        SortTest.printArr(nums);

        DynamicNumsTopK dynamicNumsTopK = new DynamicNumsTopK(5);
        for (int i : nums) {
            dynamicNumsTopK.insert(i);
        }
        dynamicNumsTopK.printAll();

        QuickSort test = new QuickSort();
        test.sort(nums);
        SortTest.printArr(nums);
    }
}
