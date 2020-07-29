package com.探索.头条.链表和树;

import com.linkList.ListNode;

public class 剑指_Offer_24_反转链表 {

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode newHead = null;
        while (head != null) {
            ListNode tempNode = head.next;
            head.next = newHead;
            newHead = head;
            head = tempNode;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        剑指_Offer_24_反转链表 o = new 剑指_Offer_24_反转链表();
        System.out.println(o.reverseList(head));
    }
}
