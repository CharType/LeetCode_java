package com.arithmetic.cq.source.tenxun;

import com.arithmetic.linkList.ListNode;

import java.util.ArrayList;
import java.util.List;

public class _61_旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        List<ListNode> array = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            array.add(node);
            node = node.next;
        }
        int h = k % array.size();
        if (h == 0) return head;
        ListNode lastNode = array.get(array.size() - 1 - h);
        ListNode newHead = lastNode.next;
        lastNode.next = null;
        ListNode arryLastNode = array.get(array.size() - 1);
        arryLastNode.next = head;
        return newHead;
    }

    // 这种方式计算有问题哦
    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int startIndex = 0;
        ListNode newHead = new ListNode(-1);
        ListNode tailNode = newHead;
        ListNode tempNode = head;
        // 先找新的head节点
        while (head != null) {
            if (startIndex == k) {
                break;
            }
            head = head.next;
            startIndex++;

            if (head == null) {
                head = tempNode;
            }
        }
        ListNode newFirstNode = head;
        while (head != null) {
            tailNode.next = head;
            head = head.next;
            tailNode = tailNode.next;
        }

        head = tempNode;
        while (head != null) {
            tailNode.next = head;
            head = head.next;
            tailNode = tailNode.next;
            if (head == newFirstNode) break;

        }
        tailNode.next = null;
        return newHead.next;
    }

    public static void main(String[] args) {
        _61_旋转链表 o = new _61_旋转链表();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println(o.rotateRight(head, 2));

    }
}
