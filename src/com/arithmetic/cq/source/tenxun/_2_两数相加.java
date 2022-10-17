package com.arithmetic.cq.source.tenxun;

import com.arithmetic.linkList.ListNode;

public class _2_两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null && l2 != null) return l2;
        if (l1 != null && l2 == null) return l1;
        // 保存是否有进位
        int curr = 0;
        ListNode resultNode = new ListNode(0);
        ListNode tailNode = resultNode;

        while (l1 != null && l2 != null) {
            int num1 = l1.val;
            l1 = l1.next;
            int num2 = l2.val;
            l2 = l2.next;
            int sum = num1 + num2 + curr;
            curr = (sum / 10);
            tailNode.next = new ListNode(sum % 10);
            tailNode = tailNode.next;
        }

        while (l1 != null) {
            int num1 = l1.val;
            l1 = l1.next;
            int sum = num1 + curr;
            curr = (sum / 10);
            tailNode.next = new ListNode(sum % 10);
            tailNode = tailNode.next;
        }

        while (l2 != null) {
            int num2 = l2.val;
            l2 = l2.next;
            int sum = num2 + curr;
            curr = (sum / 10);
            tailNode.next = new ListNode(sum % 10);
            tailNode = tailNode.next;
        }

        if (curr > 0) {
            tailNode.next = new ListNode(curr);
        }

        return resultNode.next;
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

        ListNode head4 = new ListNode(9);
        head4.next = new ListNode(9);
        head4.next.next = new ListNode(9);
        head4.next.next.next = new ListNode(9);

        System.out.println(o.addTwoNumbers(head3, head4));
    }
}
