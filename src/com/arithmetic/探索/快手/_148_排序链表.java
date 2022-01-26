package com.arithmetic.探索.快手;

import com.arithmetic.linkList.ListNode;

/**
 *
 */
public class _148_排序链表 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode h = new ListNode(0);
        ListNode tra = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tra.next = left;
                left = left.next;
            } else {
                tra.next = right;
                right = right.next;
            }
            tra = tra.next;
        }
        tra.next = left != null ? left : right;

        return h.next;


    }
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        _148_排序链表 o = new _148_排序链表();
        System.out.println(o.sortList(head));
    }

}
