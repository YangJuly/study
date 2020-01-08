package com.yangzanjie;

import java.util.*;

/**
 * @author : yangzanjie
 * create at:  2019-08-04  11:12
 * @description: 测试
 */
public class DemoTest {

    private Integer age;

    private String name;

    class Solution {
        public int findKthNumber(int n, int k) {

            int curr=1;
            k-=1;
            while(k>0){

                long step=calstep(n,curr,curr+1);

                if(k<step){//在这个范围内
                    curr*=10;//移动一层
                    k--;
                }else{//移动相邻的下一个节点
                    k-=step;
                    curr=curr+1;
                }

            }
            return curr;
        }
        public long calstep(int n,long n1,long n2){
            int ans=0;
            while(n1<=n){
                ans+=Math.min(n+1,n2)-n1;
                n1*=10;
                n2*=10;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
//        Solution solution = new DemoTest().new Solution();
//        System.out.println(solution.findKthNumber(100,4));
        int i = 0;
        int a = i++;
        System.out.println(a);
    }


    public int[] function() {
        int i = 0;
        int j = 1;
        return new int[]{i, j};
    }

    public int lengthOfLongestSubstring(String s) {
        int res = 0;

        int j = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                 j = Math.max(map.get(ch), j);
            }
            int length = i - j + 1;
            if (res < length) res = length;
            map.put(ch, i + 1);
        }
        return res;
    }

    public boolean wordPattern(String pattern, String str) {
        int i = 0;
        int n = pattern.length();
        int j = 0;
        int m = str.length();

        Map<Character, Integer> charMap = new HashMap();
        Map<String, Integer> strMap = new HashMap();

        while (i < n && j < m) {
            char ch = pattern.charAt(i);

            int temp = j;
            while (temp < m && str.charAt(temp) != ' ') temp++;
            String s = str.substring(j, temp);
            j = temp + 1;

            if (charMap.containsKey(ch)) {
                if ((!strMap.containsKey(s)) || (strMap.get(s).intValue() != charMap.get(ch).intValue()))
                    return false;
            } else {
                if (strMap.containsKey(s))
                    return false;
            }

            charMap.put(ch, i);
            strMap.put(s, i);
            i++;
        }
        return true;
    }

    public boolean isNumber(String s) {

        s = s.trim();

        boolean hasPositive = false;
        boolean hasPoint = false;
        boolean hasE = false;
        boolean hasNumber = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '+' || ch == '-') {
                if (!hasNumber || hasPositive) return false;
                hasPositive = true;
            } else if (ch == 'e') {
                if (!hasNumber|| hasE || hasPoint) return false;
                hasE = true;
                hasNumber = false;
            } else if (ch == '.') {
                if (hasE || hasPoint) return false;
                hasPoint =  true;
            } else if (ch >= '0' && ch <= '9'){
                hasNumber = true;
            } else {
                return false;
            }
        }
        if (hasNumber) return true;
        return false;
    }


    public static String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() == b.length()
                ? a.compareTo(b) : b.length() - a.length());

        int length = words.length;
        int maxStrLength = words[length-1].length();
        List<List<Integer>> dpList = new ArrayList<>();
        for (int i = 0; i < maxStrLength; i++) {
            dpList.add(new ArrayList<>());
        }

        int resIndex = -1;
        int maxLength = -1;

        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            int strLength = str.length();
            if (strLength == 1) {
                dpList.get(0).add(i);
            } else {
                List<Integer> temp = dpList.get(strLength - 2);
                if (temp.size() == 0) break;
                for (int index : temp) {
                    String strPrefix = words[index];
                    if (str.substring(0, strLength-1).equals(strPrefix)) {
                        dpList.get(strLength - 1).add(i);
                        if (strLength > maxLength) {
                            maxLength = strLength;
                            if (resIndex == -1 || words[resIndex].length() < strLength) {
                                resIndex = i;
                            } else if (words[resIndex].length() == strLength) {
                                if (resIndex > i) resIndex = i;
                            }
                        }
                    }
                }
            }
        }
        if (resIndex < 0) return null;
        return words[resIndex];
    }

    public void megreSort(int[] nums) {

    }


    public void merge(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = ((r - l) >> 1) + l;
        merge(nums, l, mid);
        merge(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    public void merge(int[] nums, int l, int mid, int r) {
        //
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a = head;
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }
        ListNode node = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return node;
    }

    //翻转区间[a,b)内的链表
    public ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, next;
        cur = a;
        pre = null;
        while (cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 递归法，翻转链表
     * @param current
     * @return
     */
    public ListNode rerverseListNode(ListNode current) {
        //递归终止条件
        if (current == null || current.next == null) return current;
        //把后面的翻转好，返回的是头结点
        ListNode result = rerverseListNode(current.next);
        //后面的已经翻转好，对当前结点，翻转一下
        current.next.next = current;
        current.next = null;
        return result;
    }


    /**
     * 输入一个int数组，返回一个数组，其中奇数都在左边，偶数都在右边，附加条件 不使用额外的空间
     * @param nums
     */
    public static void partitionEO(int[] nums) {
        int j = nums.length - 1;
        for (int i = 0; i < j;) {
            //even
            if (nums[i] % 2 == 0) {
                swap(nums, i, j);
                j--;
            } else { // odd
                i++;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
