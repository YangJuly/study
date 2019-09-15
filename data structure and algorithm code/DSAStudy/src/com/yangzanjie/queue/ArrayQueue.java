package com.yangzanjie.queue;

/**
 * @author : yangzanjie
 * create at:  2019-09-13  23:24
 * @description: 基于数组实现顺序队列
 */
public class ArrayQueue {
    /**
     * 队列容量
     */
    private int capacity;

    /**
     * 队列头下标
     */
    private int head = 0;

    /**
     * 队列尾下标
     */
    private int tail = 0;

    /**
     * 队列数组
     */
    private Integer[] data;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.data = new Integer[capacity];
    }

    /**
     * 入队
     * @param data
     * @return
     */
    public boolean enqueue(Integer data) {
        //tail = capacity，表明队尾没有空间了，数据迁移下
        if (tail == capacity) {
            //head = 0，表明没有队头没有空间，队列已满
            if (head == 0) return false;
            int count = tail - head;
            for (int i = 0; i < count; i++) {
                this.data[i] = this.data[i+head];
            }
            //刷新下head和tail
            head = 0;
            tail = count;
        }
        //迁移完数据，将数据插入队列
        this.data[tail] = data;
        tail++;
        return true;
    }

    /**
     * 出队
     * @return
     */
    public Integer dequeue() {
        if (head == tail) return null;
        Integer result = data[head];
        head++;
        return result;
    }
}
