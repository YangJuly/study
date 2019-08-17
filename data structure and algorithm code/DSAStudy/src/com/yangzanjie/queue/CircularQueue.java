package com.yangzanjie.queue;

/**
 * @author : yangzanjie
 * create at:  2019-08-03  16:39
 * @description: 循环队列：数组实现
 */
public class CircularQueue<T> {
    /**
     * 队列长度
     */
    private int capacity = 8;

    /**
     * 数组，存储队列
     */
    private String[] arrayList;

    /**
     * 头部
     */
    private int head;

    /**
     * 尾部
     */
    private int tail;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.arrayList = new String[capacity];
        this.head = 0;
        this.tail = 0;
    }

    /**
     * 入队
     * @param data
     * @return
     */
    public boolean enqueue (String data) {
        int nextIndex = (tail + 1) % capacity;
        if(nextIndex == head) {
            return false;
        } else {
            arrayList[tail] = data;
            tail = nextIndex;
            return true;
        }
    }

    /**
     * 出队
     * @return
     */
    public String dequeue() {
        if (head == tail) return null;
        String result = arrayList[head];
        head = (head + 1) % capacity;
        return result;
    }

    /**
     * 打印队列里的所有内容
     */
    public void printAll() {
        int end = tail;
        if (tail < head) {
            head = tail + capacity;
        }
        System.out.println("\n********start**********");
        for (int i =  head; i < end; i++) {
            System.out.println("Index " + i % capacity + " : " +  arrayList[i]);
        }
        System.out.println("********end*********\n");
    }

    /**
     * test
     * @param args
     */
    public static void main(String[] args) {
        CircularQueue test = new CircularQueue(8);
        for (int i = 0; i < 8; i++) {
            if (test.enqueue(new Integer(i).toString())) {
                System.out.println("enqueue " + i + " success!");
            } else {
                System.out.println("enqueue " + i + " failed!");
            }
        }

        test.printAll();

        System.out.println("dequeue one " + test.dequeue() + "  ");
        test.printAll();
    }
}
