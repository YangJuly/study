//给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。 
//
// 
//
// 示例 1： 
//
// 输入：S = "ab#c", T = "ad#c"
//输出：true
//解释：S 和 T 都会变成 “ac”。
// 
//
// 示例 2： 
//
// 输入：S = "ab##", T = "c#d#"
//输出：true
//解释：S 和 T 都会变成 “”。
// 
//
// 示例 3： 
//
// 输入：S = "a##c", T = "#a#c"
//输出：true
//解释：S 和 T 都会变成 “c”。
// 
//
// 示例 4： 
//
// 输入：S = "a#c", T = "b"
//输出：false
//解释：S 会变成 “c”，但 T 仍然是 “b”。 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 200 
// 1 <= T.length <= 200 
// S 和 T 只含有小写字母以及字符 '#'。 
// 
//
// 
// Related Topics 栈 双指针
  
package com.yangzanjie.leetcode.editor.cn;
public class BackspaceStringCompare{
    public static void main(String[] args) {
        Solution solution = new BackspaceStringCompare().new Solution();
        String s1 = "a##c";
        String s2 = "#a#c";
        System.out.println(solution.backspaceCompare(s1, s2));
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean backspaceCompare(String S, String T) {

        S = simplifyString(S);
        T = simplifyString(T);

        return S.equals(T);
    }


    private String simplifyString(String S) {
        char[] s = new char[S.length()];
        int indexS = -1;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch != '#') {
                indexS++;
                s[indexS] = ch;
            } else {
                indexS = indexS > -1 ? indexS-1 : -1;
            }
        }
        return String.valueOf(s, 0, indexS + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}