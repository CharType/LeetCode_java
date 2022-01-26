package com.arithmetic.头条高频算法题;

import com.arithmetic.linkList.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class _19_删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        // 创建一个虚拟头结点
        ListNode newHead = new ListNode(-1);
        // 设置下一个指针
        newHead.next = head;
        // 快指针
        ListNode slowHead = newHead;
        // 慢指针
        ListNode fastHead = newHead;
        for (int i = 0;i < n+1;i++) {
            // 先调整快指针走n+1 步，
            fastHead = fastHead.next;
        }
        // 当快指针走到末尾处的时候慢指针的next 正好是要删除的那个指针
        while (fastHead != null) {

            slowHead = slowHead.next;
            fastHead = fastHead.next;
        }
        // 删除到处第几的指针
        slowHead.next = slowHead.next.next;
        return newHead.next;

    }
    public static void main(String[] args) {
        _19_删除链表的倒数第N个节点 o = new _19_删除链表的倒数第N个节点();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);
        System.out.println(o.removeNthFromEnd(head,5));

    }
}
