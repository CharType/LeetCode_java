package com.cq.source.leetCode.link;

import com.linkList.ListNode;

public class _203_移除链表元素 {
    // 递归
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) return head;

        head.next = removeElements2(head.next, val);

        return head.val == val ? head.next : head;
    }

    // 迭代
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode tempHead = newHead;
        while (tempHead.next != null) {
            if (val == tempHead.next.val) {
                tempHead.next = tempHead.next.next;
            } else {
                tempHead = tempHead.next;
            }


        }

        return newHead.next;
    }

    public static void main(String[] args) {
        _203_移除链表元素 o = new _203_移除链表元素();
        ListNode head = new ListNode(6);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        ListNode newhead = o.removeElements(head, 6);
        System.out.println(newhead);

        head = new ListNode(6);
        head.next = new ListNode(6);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(6);
        newhead = o.removeElements2(head, 6);
        System.out.println(newhead);
    }
}
