//设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) -- 将元素 x 推入栈中。 
// pop() -- 删除栈顶的元素。 
// top() -- 获取栈顶元素。 
// getMin() -- 检索栈中的最小元素。 
// 
//
// 示例: 
//
// MinStackDemo minStack = new MinStackDemo();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
// Related Topics 栈 设计
  
package com.yangzanjie.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Stack;

public class MinStackDemo {
    public static void main(String[] args) {

    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

    /** initialize your data structure here. */
    private int[] nums;
    private int index;
    private int capacity = 10;
    private int min;

    public MinStack() {
        nums = new int[capacity];
        index = -1;
        min = Integer.MAX_VALUE;
    }

    private void growUpNums() {
        if (index == capacity - 1) {
            capacity = capacity + (capacity >> 1);
            nums = Arrays.copyOf(nums, capacity);
        }
    }

    public void push(int x) {
        growUpNums();
        index++;
        nums[index] = x;
        if (x < min) {
            min = x;
        }
    }
    
    public void pop() {
        if (index >= 0 ){
            if (nums[index] == min) {
                index--;
                min = Integer.MAX_VALUE;
                for (int i = 0; i <= index; i++) {
                    if (nums[i] < min) min = nums[i];
                }
            } else {
                index--;
            }
        } else {
            throw new RuntimeException("There is no data");
        }
    }
    
    public int top() {
        if (index < 0) throw new RuntimeException("There is no data");
        return nums[index];
    }
    
    public int getMin() {
        if (index < 0) throw new RuntimeException("There is no data");
        return min;
    }
}

/**
 * Your MinStackDemo object will be instantiated and called as such:
 * MinStackDemo obj = new MinStackDemo();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}