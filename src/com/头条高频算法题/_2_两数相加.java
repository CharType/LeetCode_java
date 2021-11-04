package com.头条高频算法题;

import com.linkList.ListNode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class _2_两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return new ListNode(0);
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
                tempNode.next = new ListNode(l1Index.val + l2Index.val + iscuarr - 10);
                iscuarr = 1;
            } else {
                tempNode.next = new ListNode(l1Index.val + l2Index.val + iscuarr);
                iscuarr = 0;
            }
            l1Index = l1Index.next;
            l2Index = l2Index.next;
            tempNode = tempNode.next;
        }
        while (l1Index != null) {
            if ((l1Index.val + iscuarr) >= 10) {
                tempNode.next = new ListNode(l1Index.val + iscuarr - 10);
                iscuarr = 1;
            } else {
                tempNode.next = new ListNode(l1Index.val + iscuarr);
                iscuarr = 0;
            }
            l1Index = l1Index.next;
            tempNode = tempNode.next;
        }

        while (l2Index != null) {
            if ((l2Index.val + iscuarr) >= 10) {
                tempNode.next = new ListNode(l2Index.val + iscuarr - 10);
                iscuarr = 1;
            } else {
                tempNode.next = new ListNode(l2Index.val + iscuarr);
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
        if (l1 == null && l2 == null) return new ListNode(0);
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        // 虚拟头结点
        ListNode dymnnHead = new ListNode(0);
        ListNode tailNode = dymnnHead;
        // 是否进位
        int curr = 0;
        while (l1 != null || l2 != null) {
            int number1 = 0;
            if (l1 != null) {
                number1 = l1.val;
                l1 = l1.next;
            }
            int number2 = 0;
            if (l2 != null) {
                number2 = l2.val;
                l2 = l2.next;
            }
            int sum = number1 + number2 + curr;
            curr = sum / 10;
            tailNode.next = new ListNode(sum % 10);
            tailNode = tailNode.next;
        }
        if (curr > 0) {
            tailNode.next = new ListNode(curr);
        }
        return dymnnHead.next;
    }

    public static void main(String[] args) {
        _2_两数相加 o = new _2_两数相加();
        ListNode head = new ListNode(5);
        head.next = new ListNode(9);
        head.next.next = new ListNode(3);

        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(9);
        head1.next.next = new ListNode(4);

        System.out.println(o.addTwoNumbers(head, head1));

        ListNode head3 = new ListNode(9);
        head3.next = new ListNode(9);
        head3.next.next = new ListNode(9);
        head3.next.next.next = new ListNode(9);
        head3.next.next.next.next = new ListNode(9);
        head3.next.next.next.next.next = new ListNode(9);
        head3.next.next.next.next.next.next = new ListNode(9);
        head3.next.next.next.next.next.next.next = new ListNode(9);

        ListNode head4 = new ListNode(9);
        head4.next = new ListNode(9);
        head4.next.next = new ListNode(9);
        head4.next.next.next = new ListNode(9);

        System.out.println(o.addTwoNumbers(head3, head4));
        System.out.println(o.addTwoNumbers2(head3, head4));
    }
}
