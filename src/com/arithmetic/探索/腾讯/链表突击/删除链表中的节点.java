package com.arithmetic.探索.腾讯.链表突击;

import com.arithmetic.linkList.ListNode;

public class 删除链表中的节点 {
    public void deleteNode(ListNode node) {
        if (node == null) return;
        if (node.next == null) {
            System.out.println("直接删除最后一个节点会出bug啊");
        }
        node.val = node.next.val;
        node.next = node.next.next;

    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return head;

        ListNode node = head;
        ListNode lastNode = null;
        while (node != null) {
            if (node.val == val) {
                if (lastNode == null) {
                    return node.next;
                } else {
                    lastNode.next = node.next;
                }
            } else {
               lastNode = node;
            }
            node = node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        删除链表中的节点 o = new 删除链表中的节点();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        o.deleteNode(head.next.next.next);
        o.deleteNode(head,3);
        System.out.println(head);
    }
}
