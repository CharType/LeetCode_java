package com.arithmetic.探索.快手;

import com.arithmetic.linkList.ListNode;

public class _206反转链表 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = null;
        while (head != null) {
            ListNode node = head.next;
            head.next = newHead;
            newHead = head;
            head = node;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        _206反转链表 o = new _206反转链表();
        System.out.println(o.reverseList(head));
    }
}
