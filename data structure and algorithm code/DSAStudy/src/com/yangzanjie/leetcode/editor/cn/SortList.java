//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。 
//
// 示例 1: 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2: 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5 
// Related Topics 排序 链表
  
package com.yangzanjie.leetcode.editor.cn;

import java.util.List;

public class SortList{
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
        ListNode head = new SortList().new ListNode(4);
        head.next = new SortList().new ListNode(3);
        head.next.next = new SortList().new ListNode(2);
//        head.next.next.next = new SortList().new ListNode(1);
        ListNode result = solution.sortList(head);
        System.out.println();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class Solution {
    public ListNode sortList(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        int interval = 1;
        ListNode result = head;
        int index = 0;
        while (interval < length) {
            boolean isFirst = true;
            ListNode first = result;
            ListNode second = findIndexNode(first, interval);
            ListNode lastEnd = null;
            while (first != null && second != null) {
                temp = findIndexNode(second, interval);
                int firstStart = index;
                int firstEnd = interval + index;
                int secondStart = firstEnd + 1;
                int secondEnd = secondStart + interval > length ? length : secondStart + interval;
                ListNode[] intervalResult = merge(first, second, firstStart, firstEnd, secondStart, secondEnd);
                if (isFirst) {
                    result = intervalResult[0];
                    lastEnd = intervalResult[1];
                    isFirst = false;
                } else {
                    lastEnd.next = intervalResult[0];
                    lastEnd = intervalResult[1];
                }
                first = temp;
                second = findIndexNode(first, interval);
            }
            interval = interval * 2;
        }
        return result;
    }

    private ListNode findIndexNode(ListNode start, int index) {
        int i = 0;
        while (start != null && i < index) {
            i++;
            start = start.next;
        }
        return start;
    }

    private ListNode[] merge(ListNode first, ListNode second, int firstStart, int firstEnd, int secondStart, int secondEnd) {
        ListNode[] result = new ListNode[2];
        int i = firstStart;
        int j = secondStart;
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (i < firstEnd && j < secondEnd) {
            if (first.val <= second.val) {
                temp.next = first;
                first = first.next;
                i++;
                temp = temp.next;
            } else {
                temp.next = second;
                second = second.next;
                j++;
                temp = temp.next;
            }
        }
        while (i < firstEnd) {
            temp.next = first;
            first = first.next;
            i++;
            temp = temp.next;
        }
        while (j < secondEnd) {
            temp.next = second;
            second = second.next;
            j++;
            temp = temp.next;
        }
        result[0] = head.next;
        result[1] = temp;
        temp.next = second;
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}