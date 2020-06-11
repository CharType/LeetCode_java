package com.头条高频算法题;

import com.linkList.ListNode;

public class _206_反转链表 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newhead = null;
        while (head != null) {
            ListNode tempNode = head.next;
            head.next = newhead;
            newhead = head;
            head = tempNode;
        }

        return newhead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        _206_反转链表 o = new _206_反转链表();
        System.out.println(o.reverseList(head));
    }
}
