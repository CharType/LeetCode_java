package com.cq.source.tenxun;

import com.linkList.ListNode;

public class _21_合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 != null && list2 == null) return list1;
        if (list1 == null && list2 != null) return list2;
        ListNode newHead = new ListNode(-1);
        ListNode tailNode = newHead;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                tailNode.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                tailNode.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            tailNode = tailNode.next;
        }

        while (list1 != null) {
            tailNode.next = new ListNode(list1.val);
            list1 = list1.next;
            tailNode = tailNode.next;
        }

        while (list2 != null) {
            tailNode.next = new ListNode(list2.val);
            list2 = list2.next;
            tailNode = tailNode.next;
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
