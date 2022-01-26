package com.arithmetic.探索.头条.链表和树;

import com.arithmetic.linkList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class _23_合并K个排序链表 {

    // 使用优先级队列合并
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        if (lists.length == 1) return lists[0];
        PriorityQueue<ListNode> queuq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0;i < lists.length;i++) {
            if (lists[i] != null) {
                queuq.add(lists[i]);
            }
        }
        ListNode newNode = new ListNode(-1);
        ListNode tailNode = newNode;
        while (!queuq.isEmpty()) {
            ListNode node = queuq.poll();
            tailNode.next = node;
            if (node.next != null) {
                queuq.add(node.next);
            }
            tailNode = tailNode.next;
        }
        return newNode.next;
    }

    public static void main(String[] args) {
        _23_合并K个排序链表 o = new _23_合并K个排序链表();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);
        ListNode [] lists = {head1,head2,head3};
        System.out.println(o.mergeKLists(lists));
    }
}
