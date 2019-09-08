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
import java.util.PriorityQueue;

public class MergeKSortedLists{
    public static void main(String[] args) {
         Solution solution = new MergeKSortedLists().new Solution();
    }
      

//leetcode submit region begin(Prohibit modification and deletion)

//   Definition for singly-linked list.
   public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

class Solution {

    /**
     * 优先级队列的实现。
     * 时间复杂度O(Nlogk),N是链表的平均长度，k是链表个数
     * 空间复杂度，O(k)
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length == 0) return null;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(length, Comparator.comparingInt(a -> a.val));
        ListNode dummyNode = new ListNode(-1);
        ListNode curNode = dummyNode;
        for (ListNode list : lists) {
            if (list != null) {
                // 这一步很关键，不能也没有必要将空对象添加到优先队列中
                priorityQueue.add(list);
            }
        }
        while (!priorityQueue.isEmpty()) {
            // 优先队列非空才能出队
            ListNode node = priorityQueue.poll();
            // 当前节点的 next 指针指向出队元素
            curNode.next = node;
            // 当前指针向前移动一个元素，指向了刚刚出队的那个元素
            curNode = curNode.next;
            if (curNode.next != null) {
                // 只有非空节点才能加入到优先队列中
                priorityQueue.add(curNode.next);
            }
        }
        return dummyNode.next;
    }

    /**
     * 分治法实现
     * 时间复杂度O(Nlogk),N是链表的平均长度，k是链表个数
     * 空间复杂度，主要消耗在递归上
     * @param lists
     * @return
     */
    public ListNode mergeKListsTwo(ListNode[] lists) {
        if (lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {
        if (end == start) return lists[start];
        int mid = (end + start) / 2;
        ListNode one = merge(lists, start, mid);
        ListNode two = merge(lists, mid+1, end);
        return mergeTwoList(one, two);
    }

    private ListNode mergeTwoList(ListNode listOne, ListNode listTwo) {
        ListNode head = new ListNode(0);
        ListNode result = head;
        while(listOne != null && listTwo != null) {
            if (listOne.val <= listTwo.val) {
                result.next = listOne;
                listOne = listOne.next;
            } else {
                result.next = listTwo;
                listTwo = listTwo.next;
            }
            result = result.next;
        }
        while (listOne != null) {
            result.next = listOne;
            listOne = listOne.next;
            result = result.next;
        }
        while (listTwo != null) {
            result.next = listTwo;
            listTwo = listTwo.next;
            result = result.next;
        }
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}