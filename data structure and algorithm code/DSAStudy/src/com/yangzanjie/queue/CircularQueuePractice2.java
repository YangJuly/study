package com.yangzanjie.queue;

/**
 * @author : yangzanjie
 * create at:  2019-09-14  11:33
 * @description: 基于数组实现循环队列
 * 第二遍练习，不够熟练
 */
public class CircularQueuePractice2 {
    /**
     * 队列数组
     */
    private Integer[] queue;

    private int capacity;

    private int head = 0;

    private int tail = 0;

    public CircularQueuePractice2(int capacity) {
        this.capacity = capacity;
        this.queue = new Integer[capacity];
    }

    /**
     * 入队
     * @param data
     */
    public boolean enqueue(Integer data) {
        int nextIndex = (tail + 1) / capacity;
        if (nextIndex == head) return false;
        queue[nextIndex] = data;
        tail = nextIndex;
        return true;
    }

    /**
     * 出队
     * @return
     */
    public Integer dequeue() {
        if (head == tail) return null;
        Integer value = queue[head];
        head = (head + 1) % capacity;
        return value;
    }
}
