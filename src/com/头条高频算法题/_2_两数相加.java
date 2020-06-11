package com.头条高频算法题;

import com.linkList.ListNode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class _2_两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return  new ListNode(0);
        if (l1 != null && l2 == null) return l1;
        if (l1 == null && l2 != null) return l2;
        // 保存是否有进位
        Integer iscuarr = 0;
        ListNode l1Index = l1;
        ListNode l2Index = l2;
        ListNode newNodel = new ListNode(-1);
        ListNode tempNode = newNodel;
        while (l1Index != null && l2Index != null) {
            if ((l1Index.val + l2Index.val + iscuarr) >= 10) {
                tempNode.next = new ListNode (l1Index.val + l2Index.val +iscuarr - 10);
                iscuarr = 1;
            } else {
                tempNode.next = new ListNode (l1Index.val + l2Index.val +iscuarr);
                iscuarr = 0;
            }
            l1Index = l1Index.next;
            l2Index = l2Index.next;
            tempNode = tempNode.next;
        }
        while (l1Index != null) {
            if ((l1Index.val + iscuarr)  >= 10) {
                tempNode.next = new ListNode (l1Index.val +iscuarr - 10);
                iscuarr = 1;
            } else {
                tempNode.next = new ListNode (l1Index.val +iscuarr);
                iscuarr = 0;
            }
            l1Index = l1Index.next;
            tempNode = tempNode.next;
        }

        while (l2Index != null) {
            if ((l2Index.val + iscuarr)  >= 10) {
                tempNode.next = new ListNode (l2Index.val +iscuarr - 10);
                iscuarr = 1;
            } else {
                tempNode.next = new ListNode (l2Index.val +iscuarr);
                iscuarr = 0;
            }
            l2Index = l2Index.next;
            tempNode = tempNode.next;
        }

        if (iscuarr == 1) {
            tempNode.next = new ListNode(iscuarr);
        }
        return newNodel.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return  new ListNode(0);
        if (l1 != null && l2 == null) return l1;
        if (l1 == null && l2 != null) return l2;
        // 保存是否有进位
        Integer iscuarr = 0;
        ListNode l1Index = l1;
        ListNode l2Index = l2;
        ListNode newNodel = new ListNode(-1);
        ListNode tempNode = newNodel;

        return newNodel.next;
    }

    public static void main(String[] args) {
        _2_两数相加 o = new _2_两数相加();
        ListNode head = new ListNode(5);
//        head.next = new ListNode(9);
//        head.next.next = new ListNode(3);

        ListNode head1 = new ListNode(5);
//        head1.next = new ListNode(9);
//        head1.next.next = new ListNode(4);

        System.out.println(o.addTwoNumbers(head,head1));
    }
}
