package com.arithmetic.腾讯精选练习;

import com.arithmetic.linkList.ListNode;

public class _24_反转链表 {
    public ListNode reverseList(ListNode head) {
        

        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        _24_反转链表 o = new _24_反转链表();
        System.out.println(o.reverseList(head));

    }
}
