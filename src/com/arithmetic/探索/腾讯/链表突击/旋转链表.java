package com.arithmetic.探索.腾讯.链表突击;

import com.arithmetic.linkList.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/explore/interview/card/tencent/222/linked-list/915/
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 */
public class 旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) return head;
        ListNode node = head;
        List<ListNode> list = new ArrayList<>();
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int h = k % list.size();
        if (h == 0) return head;
        ListNode lastNode = list.get(list.size() - 1 - h);
        ListNode newHead = lastNode.next;
        lastNode.next = null;
        ListNode arrayLastNode = list.get(list.size() - 1);
        arrayLastNode.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        旋转链表 o = new 旋转链表();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(o.rotateRight(head,3));

//        ListNode head1 = new ListNode(0);
//        head1.next = new ListNode(1);
//        head1.next.next = new ListNode(2);
//
//        System.out.println(o.rotateRight(head1,4));
    }
}
