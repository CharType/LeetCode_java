package com.cq.source.leetCode.link;

import com.linkList.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class _83_删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        // 记录下一个节点
        ListNode tempHead = head.next;
        // 记录当前节点
        ListNode prevHead = head;
        // 记录头部节点
        ListNode newHead = prevHead;
        while (tempHead != null) {
            // 如果当前节点和下一个节点不等
            if (tempHead.val != prevHead.val) {
                // 在上一个节点后面拼接上当前不一样的节点
                prevHead.next = tempHead;
                // 更新上一个节点，下一次循环使用
                prevHead = tempHead;
            } else {
                // 如果想等，更新上一个节点尾部的值，避免链表尾部是连续的相等的情况
                prevHead.next = null;
            }
            tempHead = tempHead.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(3);
        _83_删除排序链表中的重复元素 o = new _83_删除排序链表中的重复元素();
        System.out.println(o.deleteDuplicates(head));
    }
}
