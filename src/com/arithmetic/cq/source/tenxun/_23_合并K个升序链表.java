package com.arithmetic.cq.source.tenxun;

import com.arithmetic.linkList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _23_合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        // 使用优先级队列
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue(new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            priorityQueue.add(lists[i]);
        }

        ListNode newHead = new ListNode(-1);
        ListNode tailNode = newHead;
        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            tailNode.next = node;
            tailNode = tailNode.next;
            if (node.next != null) {
                priorityQueue.add(node.next);
            }
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        _23_合并K个升序链表 o = new _23_合并K个升序链表();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);
        ListNode[] nodes = {head, head2};
        System.out.println(o.mergeKLists(nodes));
    }
}
