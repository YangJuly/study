package com.yangzanjie.heap;

/**
 * @author : yangzanjie
 * create at:  2019-09-19  16:26
 * @description: 基于大顶堆实现的优先级队列
 *
 */
public class PriorityQueue {
    private int count = 0;
    private int maxSize;
    private int[] data;

    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        this.data = new int[maxSize + 1];
    }

    /**
     * 入队
     * @param value
     * @return
     */
    public boolean enqueue(int value) {
        if (count >= maxSize) return false;
        ++count;
        data[count] = value;

        int i = count;
        while (i / 2 > 0 && data[i / 2] < data[i]) {
            swap(data, i, i / 2);
            i = i / 2;
        }
        return true;
    }

    /**
     * 出队
     * @return
     */
    public Integer dequeue() {
        if (count == 0) return null;
        int result = data[1];
        data[1] = data[count];
        --count;
        heapify(data, count, 1);
        return result;
    }

    private void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPosi = i;
            if (i * 2 <= n && a[maxPosi] < a[i * 2]) maxPosi = 2 * i;
            if (i * 2 + 1 <= n && a[maxPosi] < a[i * 2 + 1]) maxPosi = i * 2 + 1;
            if (maxPosi == i) break;
            swap(a, maxPosi, i);
            i = maxPosi;
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] =  temp;
    }

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue(10);
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(queue.dequeue());
        }
    }
}
