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
        String str = "(()";
        System.out.println(solution.longestValidParentheses(str));
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 动态规划法，时间O(n), 空间O(n)
      * @param s
     * @return
     */
    public int longestValidParenthesesDP(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    dp[i] = (i-2 > 0) ? dp[i-2] + 2 : 2;
                } else {
                    if (i - dp[i-1] > 0) {
                        if (s.charAt(i - dp[i-1] - 1) == '(') {
                            dp[i] = (i - dp[i-1] - 2) > 0 ? dp[i-1] + dp[i - dp[i-1] - 2] + 2 : dp[i-1] + 2;
                        }
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * left、right法，时间O(n), 空间O(1)
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (right > left) {
                right = 0;
                left = 0;
            } else if (right == left) {
                max = Math.max(max, left + right);
            }
        }

        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                right++;
            } else {
                left++;
            }
            if (left > right) {
                right = 0;
                left = 0;
            } else if (right == left) {
                max = Math.max(max, left + right);
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}