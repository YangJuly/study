package com;

/**
 * @author : yangzanjie
 * create at:  2019-12-26  14:59
 * @description: test
 */
public class Demo {

    class ListNode {
        int val;
        ListNode next;
    }

    //翻转 --  可用递归  -- 此处用了遍历循环
    public ListNode reverse(ListNode node)  {
        ListNode pre = null;
        ListNode cur = node;
        ListNode next = node.next;

        while (cur != null) {
            cur.next = pre;

            pre  = cur;
            cur = next;
            next = cur.next;
        }

        return pre;
    }

    //add
    //低位在前
    public ListNode add(ListNode a, ListNode b) {
        ListNode  res = new ListNode();
        ListNode resTmep = res;
        int count = 0;
        //优化点
        while (!(a == null && b == null && count == 0)) {
            ListNode temp = new ListNode();
            int sum = 0;
            sum = sum + (a == null ? 0 : a.val);
            sum = sum + (b == null ? 0 : b.val);
            sum += count;

            temp.val =  sum % 10;

            count = sum / 10;

            res.next = temp;
            res = res.next;

            if (a != null) a  = a.next;
            if (b != null) b = b.next;
        }
        return resTmep.next;
    }

    //调用框架
    public void addTwo(ListNode node1, ListNode node2) {

    }

    //test
    public static void main(String[] args) {

    }

}
