package com.cq.source.leetCode.link;

import com.linkList.ListNode;

public class _876_链表的中间结点 {
    public ListNode middleNode(ListNode head) {
        // 链表为空，或者只有一个节点 直接返回
        if (head == null || head.next == null) return head;
        // 定义快指针
        ListNode fast = head;
        // 定义慢指针
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            // 慢指针一次走一步
            slow = slow.next;
            //快指针一次走二步，
            fast = fast.next.next;
        }
        // 当快指针走到终点的时候结束循环,这个时候慢指针正好走在中间的位置
        return slow;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        _876_链表的中间结点 o = new _876_链表的中间结点();
        System.out.println(o.middleNode(head));
    }
}
