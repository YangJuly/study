package com.yangzanjie.heap;

/**
 * @author : yangzanjie
 * create at:  2019-09-19  15:25
 * @description: 复习一：实现一个小顶堆
 */
public class MinHeap {

    private int maxSize;

    private int count = 0;

    private Integer[] data;

    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.data = new Integer[maxSize + 1];
    }

    /**
     * 往堆中插入一个数据，自下而上堆化
     * @param value
     */
    public void insert(int value) {
        if (this.count >= this.maxSize) return;
        ++count;
        data[count] = value;
        int i = count;
        while (i/2 > 0 && data[i] < data[i/2]) {
            swap(i, i/2);
            i = i/2;
        }
    }

    /**
     * 删除堆顶节点的数据
     */
    public void removeMin() {
        if (this.count < 1) return;
        data[1] = data[count];
        --count;
        heapify(data, count, 1);
    }

    /**
     * 自上而下堆化
     * @param a
     * @param n
     * @param i
     */
    private void heapify(Integer[] a, int n, int i) {
        while (true) {
            int minPosi = i;
            if (2 * i <= n && a[minPosi] > a[2 * i]) minPosi = 2 * i;
            if (2 * i + 1 <= n && a[minPosi] > a[2 * i + 1]) minPosi = 2 * i + 1;
            if (i == minPosi) break;
            swap(i, minPosi);
            i = minPosi;
        }
    }

    private void swap(int i, int j) {
        Integer temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        for (int i = 0; i < 10; i++) {
            minHeap.insert(i);
        }
        System.out.println(minHeap.data[1]);
        minHeap.removeMin();
        System.out.println(minHeap.data[1]);
    }
}
