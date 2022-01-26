package com.arithmetic.探索.头条.链表和树;

import com.arithmetic.linkList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/sort-list/
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class _148_排序链表 {
    // 使用堆
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode temp = head;
        while (temp != null) {
            queue.add(temp);
            temp = temp.next;
        }
        ListNode newHead = new ListNode(-1);
        ListNode tailNode = newHead;
        while (!queue.isEmpty()) {
            tailNode.next = queue.remove();
            tailNode = tailNode.next;
        }
        tailNode.next = null;
        return newHead.next;
    }
    // 分治法
    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) return head;
        // 定义快慢指针
        ListNode fast = head.next, slow = head;
        // 找到head节点的中间节点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tmp = slow.next;
        slow.next = null;
        // 左右两边继续分治
        ListNode left = sortList1(head);
        ListNode right = sortList1(tmp);
        // 合并左右两个链表
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
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
