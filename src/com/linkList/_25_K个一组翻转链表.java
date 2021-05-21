package com.linkList;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class _25_K个一组翻转链表 {
    //TODO:还未做
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return  head;
        int i = k;

        ListNode newHead = null;
        while (head != null) {
            ListNode tempNode = head.next;
            head.next = newHead;
            newHead = head;
            head = tempNode;
        }
        return newHead;
    }

    public static void main(String[] args) {
        _25_K个一组翻转链表 o = new _25_K个一组翻转链表();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(o.reverseKGroup(head, 3));
    }
}
