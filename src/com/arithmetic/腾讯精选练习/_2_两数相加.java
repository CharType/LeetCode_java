package com.arithmetic.腾讯精选练习;

import com.arithmetic.linkList.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 */
public class _2_两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        if (l1 != null && l2 == null) return l1;
        if (l2 != null && l1 == null) return l2;
        // 保存最终的结果
        ListNode resultNode = new ListNode(-1);
        ListNode head = resultNode;
        // 保存是否有进位
        int carry = 0;
        ListNode tempNode1 = l1;
        ListNode tempNode2 = l2;
        while (tempNode1 != null && tempNode2 != null) {
            int sum = tempNode1.val + tempNode2.val;
            sum += carry;
            if (sum >= 10) {
                sum = sum - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode result = new ListNode(sum);
            resultNode.next = result;
            resultNode = resultNode.next;
            tempNode1 = tempNode1.next;
            tempNode2 = tempNode2.next;
        }

        while (tempNode1 != null) {
            int sum = tempNode1.val + carry;
            if (sum >= 10) {
                sum = sum - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode result = new ListNode(sum);
            resultNode.next = result;
            resultNode = resultNode.next;
            tempNode1 = tempNode1.next;
        }

        while (tempNode2 != null) {
            int sum = tempNode2.val + carry;
            if (sum >= 10) {
                sum = sum - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode result = new ListNode(sum);
            resultNode.next = result;
            resultNode = resultNode.next;
            tempNode2 = tempNode2.next;
        }

        if (carry > 0) {
            ListNode result = new ListNode(carry);
            resultNode.next = result;
        }

        return head.next;
    }

    public static void main(String[] args) {
        _2_两数相加 o = new _2_两数相加();
//        ListNode head = new ListNode(2);
//        head.next = new ListNode(4);
//        head.next.next = new ListNode(3);
//
//        ListNode head1 = new ListNode(5);
//        head1.next = new ListNode(6);
//        head1.next.next = new ListNode(4);

        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);
        head.next.next.next = new ListNode(9);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(9);


        ListNode head1 = new ListNode(9);
        head1.next = new ListNode(9);
        head1.next.next = new ListNode(9);
        head1.next.next.next = new ListNode(9);

        System.out.println(o.addTwoNumbers(head,head1));
    }
}
