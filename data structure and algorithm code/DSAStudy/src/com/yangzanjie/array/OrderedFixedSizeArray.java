package com.yangzanjie.array;

/**
 * @author : yangzanjie
 * create at:  2019-09-07  15:04
 * @description: 实现一个大小固定的有序数组，顺序从小到大,支持动态增删改查操作
 */
public class OrderedFixedSizeArray {
    /**
     * 有序数组初始大小为5
     */
    private int capacity = 5;

    private int[] data;

    /**
     * 当前存储数据的数量
     */
    private int count = 0;

    public OrderedFixedSizeArray() {
        this.data = new int[this.capacity];
    }

    public OrderedFixedSizeArray(int capacity) {
        this.capacity = capacity;
        this.data = new int[this.capacity];
    }

    /**
     * 往有序数组添加一个元素
     * @param number
     * @return
     */
    public boolean add(int number) {
        if (this.count == this.capacity) return false;
        this.data[count++] = number;
        //数组有序化
        sort();
        return true;
    }

    /**
     * 删除索引为index的元素
     * @param index
     * @return
     */
    public boolean delete(int index) {
        if (index < 0 || index > this.count - 1) return false;
        this.count--;
          for (int i = index; i < this.count; i++) {
            this.data[i] = this.data[i+1];
        }
        return true;
    }

    /**
     * 打印数组内容
     */
    public void printAll() {
        System.out.println("\n*************strat**************");
        System.out.println("capacity: " + this.capacity);
        System.out.println("count: " + this.count);
        for (int i = 0; i < this.capacity; i++) {
            System.out.print(this.data[i] + " -> ");
        }
        System.out.println("\n*************end**************\n");
    }

    /**
     * 数组的有序化
     */
    private void sort() {
        if (this.count <= 1) return;
        for (int i = 0; i < this.count - 1; i++) {
            if (this.data[i] > this.data[this.count -  1]) {
                //todo 这里可以优化，swap交换相比于，比较大小，插入，迁移数据，处理步骤多一些
                swap(i, this.count - 1);
            }
        }
    }

    /**
     * 交换数组的两个元素
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        int temp = this.data[i];
        this.data[i] = this.data[j];
        this.data[j] = temp;
    }
}
