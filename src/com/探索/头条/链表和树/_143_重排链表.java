package com.探索.头条.链表和树;

import com.linkList.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/reorder-list/
 */
public class _143_重排链表 {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int begin = 0;
        int end = list.size()-1;
        while (begin < end) {
            ListNode firstNode = list.get(begin);
            ListNode sendNode = list.get(begin+1);
            ListNode endNode = list.get(end);
            firstNode.next = endNode;
            endNode.next = sendNode;
            begin++;
            end--;
        }
        if (begin == end || begin > end) list.get(begin).next = null;

    }

    public static void main(String[] args) {
        _143_重排链表 o = new _143_重排链表();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        System.out.println(head);
        o.reorderList(head);
        System.out.println(head);
    }
}
