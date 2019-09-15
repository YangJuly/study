package com.yangzanjie.stack;

/**
 * @author : yangzanjie
 * create at:  2019-09-09  19:59
 * @description: 数组实现的顺序栈
 */
public class ArrayStack {
    /**
     * 栈的容量
     */
    private int capacity;

    /**
     * 栈的当前存储量
     */
    private int count = 0;


    private String[] stack;

    public ArrayStack() {
        this.capacity = 5;
        this.stack = new String[this.capacity];
    }

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.stack = new String[this.capacity];
    }

    /**
     * 入栈
     * @param data
     * @return
     */
    public boolean push(String data) {
        if (this.count >= this.capacity) {
            return false;
        }
        this.stack[count] = data;
        count++;
        return true;
    }

    /**
     * 出栈
     * @return
     */
    public String poll() {
        if (count < 1) return null;
        String result = this.stack[count-1];
        count--;
        return result;
    }

    /**
     * 强行入栈，若满了，会剔除最早入栈的数据，然后再入栈
     * @return
     */
    public boolean pushForce(String data) {
        if (this.count > this.capacity) return false;
        if (this.count == this.capacity) {
            for (int i = 0; i < this.capacity - 1; i++){
                this.stack[i] = this.stack[i+1];
            }
            this.count--;
        }
        this.stack[count] = data;
        count++;
        return true;
    }

    /**
     * 清空栈
     */
    public void clean() {
        this.count = 0;
    }
}
