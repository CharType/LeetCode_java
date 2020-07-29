package com.探索.头条.链表和树;

import com.linkList.ListNode;
import com.tools.Asserts;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class _160_相交链表 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode currNodeA = headA;
        ListNode currNodeB = headB;
        while (currNodeA != currNodeB) {
            currNodeA = currNodeA != null ? currNodeA.next : headB;
            currNodeB = currNodeB != null ? currNodeB.next : headA;
        }
        return currNodeA;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(0);
        ListNode head4 = new ListNode(4);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;


        ListNode head5 = new ListNode(5);
        head5.next = head3;


        _160_相交链表 o = new _160_相交链表();
        Asserts.test(o.getIntersectionNode(head,head5).val == 0);
    }

}
