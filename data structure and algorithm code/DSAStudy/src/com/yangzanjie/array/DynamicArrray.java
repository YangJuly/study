package com.yangzanjie.array;

/**
 * @author : yangzanjie
 * create at:  2019-09-07  14:32
 * @description: 支持动态扩容的数组，数据类型为String
 */
public class DynamicArrray {
    /**
     * 初始大小为10
     */
    private int capacity = 10;

    private String[] data;

    /**
     * 当前存储数据的数量
     */
    private int count = 0;

    public DynamicArrray() {
        this.data = new String[this.capacity];
    }

    public DynamicArrray(int capacity) {
        //todo capacity需要做校验
        this.capacity = capacity;
        this.data = new String[this.capacity];
    }

    /**
     * 往数组加入数据
     * @param str
     * @return
     */
    public String[] add(String str) {
        //当已经存储的数据大于容量时，进行扩容
        if (this.count >= this.capacity) {
            expand();
        }
        this.data[count++] = str;
        return this.data;
    }

    public void printAll() {
        System.out.println("\n\n*******start*******");
        System.out.println("capacity: " + this.capacity);
        System.out.println("count: " + this.count);
        for (int i = 0; i < this.count; i++) {
            System.out.print(this.data[i] + "  ->  ");
        }
        System.out.println("\n********end********\n\n");
    }

    public String[] getData() {
        return data;
    }

    /**
     * 扩容数组，策略，扩充为原来大小的两倍大小
     */
    private void expand() {
        String[] newData =  new String[this.capacity * 2];
        for (int i = 0; i < this.capacity; i++) {
            newData[i] = this.data[i];
        }
        this.capacity = this.capacity * 2;
        this.data  = newData;
    }
}
