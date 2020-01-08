//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 注意： 
//
// 
// num1 和num2 的长度都小于 5100. 
// num1 和num2 都只包含数字 0-9. 
// num1 和num2 都不包含任何前导零。 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。 
// 
// Related Topics 字符串
  
package com.yangzanjie.leetcode.editor.cn;
public class AddStrings{
    public static void main(String[] args) {
        Solution solution = new AddStrings().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >=0 || carry > 0; i--, j--) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int pop = x + y + carry;
            carry = pop / 10;
            res.append((pop % 10));
        }
        res = res.reverse();
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}