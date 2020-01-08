//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法
  
package com.yangzanjie.leetcode.editor.cn;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists{
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        int[][] nums = {{},{1}};
        ListNode[] lists = toListNodes(nums);
        ListNode result = solution.mergeKLists(lists);
        System.out.println();
    }

    public static ListNode[] toListNodes(int[][] nums){
        if (nums.length == 0) return null;
        ListNode[] listNodes = new ListNode[nums.length];
        for (int i = 0; i < listNodes.length; i++) {
            listNodes[i] = toListNode(nums[i]);
        }
        return listNodes;
    }

    public static ListNode toListNode(int[] nums){
        if (nums.length == 0) return null;
        ListNode listNode = new MergeKSortedLists().new ListNode(0);
        ListNode head = listNode;
        for (int i : nums) {
            listNode.next = new MergeKSortedLists().new ListNode(i);
            listNode = listNode.next;
        }
        return head.next;
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 ) return null;
        sort(lists, 0, lists.length - 1);
        return lists[0];
    }

    public void sort(ListNode[] lists, int l, int r) {
        if (l >= r) return;
        int mid = ((r - l) >> 1) + l;
        sort(lists, l, mid);
        sort(lists, mid + 1, r);
        merge(lists, l, mid, r);
    }

    public void merge(ListNode[] lists, int l, int mid, int r) {
        ListNode left = lists[l];
        ListNode right = lists[mid + 1];

        ListNode result = new ListNode(0);
        ListNode head = result;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                result.next = left;
                left = left.next;
            } else {
                result.next = right;
                right = right.next;
            }
            result = result.next;
        }

        while (left != null) {
            result.next = left;
            left = left.next;
            result = result.next;
        }

        while (right != null) {
            result.next = right;
            right = right.next;
            result = result.next;
        }
        lists[l] = head.next;
    }



    /**
     * 优先级队列实现
     */
    public ListNode mergeKListsTwo(ListNode[] lists) {
        if (lists.length == 0 ) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(
                ((ListNode o1, ListNode o2) -> {
                    return o1.val - o2.val;
                }));

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }
        ListNode results = new ListNode(0);
        ListNode head = results;
        while (!queue.isEmpty()) {
            ListNode temp = queue.poll();
            if (temp.next != null) queue.add(temp.next);
            head.next = temp;
            head = head.next;
        }
        return results.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}