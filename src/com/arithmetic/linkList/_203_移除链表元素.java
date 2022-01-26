package com.arithmetic.linkList;


/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class _203_移除链表元素 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode current = newHead;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        _203_移除链表元素 o = new _203_移除链表元素();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        ListNode newhead = o.removeElements(head,6);
        System.out.println(newhead);

    }
}
