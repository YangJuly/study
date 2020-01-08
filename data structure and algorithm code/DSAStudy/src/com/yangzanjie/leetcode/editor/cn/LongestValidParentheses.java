//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。 
//
// 示例 1: 
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
// 
//
// 示例 2: 
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
// 
// Related Topics 字符串 动态规划
  
package com.yangzanjie.leetcode.editor.cn;

import java.util.Stack;

public class LongestValidParentheses{
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
        String str = "(()())";
        System.out.println(solution.longestValidParentheses(str));
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        int maxCount = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (right > left) {
                left = 0;
                right = 0;
            } else if (right == left) {
                maxCount = Math.max(maxCount, right+left);
            }
        }
        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--)  {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left > right) {
                left = 0;
                right = 0;
            } else if (right == left) {
                maxCount = Math.max(maxCount, right+left);
            }
        }
        return maxCount;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}