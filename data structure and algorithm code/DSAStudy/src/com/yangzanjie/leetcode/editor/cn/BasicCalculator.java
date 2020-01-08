//实现一个基本的计算器来计算一个简单的字符串表达式的值。 
//
// 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格 。 
//
// 示例 1: 
//
// 输入: "1 + 1"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: " 2-1 + 2 "
//输出: 3 
//
// 示例 3: 
//
// 输入: "(1+(4+5+2)-3)+(6+8)"
//输出: 23 
//
// 说明： 
//
// 
// 你可以假设所给定的表达式都是有效的。 
// 请不要使用内置的库函数 eval。 
// 
// Related Topics 栈 数学
  
package com.yangzanjie.leetcode.editor.cn;

import java.util.Stack;

public class BasicCalculator{
    public static void main(String[] args) {
        Solution solution = new BasicCalculator().new Solution();
        String s = "1-(3+5-2+(3+19-(3-1-4+(9-4-(4-(1+(3)-2)-5)+8-(3-5)-1)-4)-5)-4+3-9)-4-(3+2-5)-10";
        System.out.println(solution.calculate(s));
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int index = 0;
    public int calculate(String s) {
        index = 0;
        return cal(s);
    }

    private int cal(String s) {
        boolean isPositive = true;
        int res = 0;
        while (index < s.length()) {
            char ch = s.charAt(index);
            if (s.charAt(index) >= '0' && s.charAt(index) <= '9')  {
                int num = 0;
                for (; index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9'; index++) {
                    num = num * 10 + (s.charAt(index) - '0');
                }
                res = res + (isPositive ? num : -num);
            } else if (ch == ' ') {
                index++;
            } else if (ch == '(') {
                index++;
                res = res + (isPositive ? cal(s) : - cal(s));
            } else if (ch == ')') {
                index++;
                return res;
            } else if (ch == '+') {
                index++;
                isPositive = true;
            } else if (ch == '-') {
                index++;
                isPositive = false;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}