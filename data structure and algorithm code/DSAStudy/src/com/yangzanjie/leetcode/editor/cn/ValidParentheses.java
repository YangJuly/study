//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串
  
package com.yangzanjie.leetcode.editor.cn;
public class ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        String str = "(){}[]";
        System.out.println(solution.isValid(str));
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Stack stack = new Stack();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
                stack.push(chars[i]);
            } else {
                char value = stack.poll();
                if (chars[i] == ')') {
                    if (value != '(')
                        return false;
                }
                if (chars[i] == ']') {
                    if (value != '[')
                        return false;
                }
                if (chars[i] == '}') {
                    if (value != '{')
                        return false;
                }
            }
        }
        if (stack.poll() == 'a')
            return true;
        else
            return false;
    }

    class Stack {
        class Node {
            private char data;
            private Node nextNode;

            public Node(char data) {
                this.data = data;
                this.nextNode = null;
            }
        }
        private Node head;

        public Stack() {
            this.head = null;
        }

        //入栈
        public void push(char str) {
            Node node = new Node(str);
            node.nextNode = this.head;
            this.head = node;
        }
        //出栈
        public char poll() {
            if (this.head == null) return 'a';
            char value = this.head.data;
            this.head = this.head.nextNode;
            return value;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}