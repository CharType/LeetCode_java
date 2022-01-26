package com.arithmetic.探索.快手;

import com.arithmetic.linkList.ListNode;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class _21合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null ) return null;
        if (l1 == null && l2 != null ) return l2;
        if (l1 != null && l2 == null ) return l1;
        ListNode newhead = new ListNode(-1);
        ListNode tranNode = newhead;
        ListNode head1 = l1;
        ListNode head2 = l2;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                 tranNode.next = head1;
                 head1 = head1.next;
            } else {
                 tranNode.next = head2;
                 head2 = head2.next;
            }
            tranNode = tranNode.next;
        }
        while (head1 != null) {
            tranNode.next = head1;
            head1 = head1.next;
            tranNode = tranNode.next;
        }

        while (head2 != null) {
            tranNode.next = head2;
            head2 = head2.next;
            tranNode = tranNode.next;
        }

        return newhead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);
        _21合并两个有序链表 o = new _21合并两个有序链表();
        System.out.println(o.mergeTwoLists(head,head2));
    }
}
