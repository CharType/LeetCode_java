package com.探索.头条.链表和树;

import com.linkList.ListNode;

public class _21_合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null && l2 != null) return l2;
        if (l1 != null && l2 == null) return l1;
        ListNode newHead = new ListNode(-1);
        ListNode oldNode = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                oldNode.next = l1;
                l1 = l1.next;
            } else {
                oldNode.next = l2;
                l2 = l2.next;
            }
            oldNode = oldNode.next;
        }
        if (l1 != null) {
            oldNode.next = l1;
        }

        if (l2 != null) {
            oldNode.next = l2;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        _21_合并两个有序链表 o = new _21_合并两个有序链表();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);
        System.out.println(o.mergeTwoLists(head, head2));
    }
}
