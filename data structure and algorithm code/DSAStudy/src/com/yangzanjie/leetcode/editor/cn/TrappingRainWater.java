//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针
  
package com.yangzanjie.leetcode.editor.cn;

import java.util.Stack;

public class TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 暴力法
    public int trap1(int[] height) {
        int size  = height.length;
        int ans = 0;
        for (int i = 1; i < size - 1; i++) {
            int maxLeft = height[i];
            for (int j = i - 1; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            int maxRight = height[i];
            for (int j = i + 1; j < size; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            ans += Math.min(maxLeft, maxRight) - height[i];
        }
        return ans;
    }

    // 动态法，提前存储每一列的 maxLeft, maxRight
    public int trap2(int[] height) {
        int size  = height.length;
        if(size < 1) return 0;
        int[] maxLeft = new int[size];
        int[] maxRight = new int[size];

        maxLeft[0] = height[0];
        maxRight[size - 1] = height[size - 1];
        for (int i = 1; i < size - 1; i++) {
            if (maxLeft[i - 1] >= height[i]) {
                maxLeft[i] = maxLeft[i - 1];
            } else {
                maxLeft[i] = height[i];
            }
            if (maxRight[size - i] >= height[size - i - 1]) {
                maxRight[size - i - 1] = maxRight[size - i];
            } else {
                maxRight[size - i - 1] = height[size - i - 1];
            }
        }

        int ans = 0;
        for (int i = 1; i < size - 1; i++) {
            ans += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return ans;
    }

    //双指针法
    public int trap3(int[] height) {
        int size = height.length;
        int i = 0;
        int j = size - 1;
        int ans = 0;
        int maxLeft = 0;
        int maxRight = 0;
        while (i < j) {
            if (height[i] <= height[j]) {
                //process left - i
                if (height[i] > maxLeft) {
                    maxLeft = height[i];
                } else {
                    ans += maxLeft - height[i];
                }
                i++;
            } else {
                //process right - j
                if (height[j] > maxRight) {
                    maxRight = height[j];
                } else {
                    ans += maxRight - height[j];
                }
                j--;
            }
        }
        return ans;
    }

    //栈法
    public int trap(int[] height) {
        int size = height.length;
        if (size < 1) return 0;
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        int i = 0;
        while (i < size) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;
                int distance = i - stack.peek() - 1;
                int boundaryHeight = Math.min(height[i], height[stack.peek()]) - height[top];
                ans += distance * boundaryHeight;
            }
            stack.push(i++);
        }
        return ans;
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}