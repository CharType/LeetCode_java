package com.arithmetic.探索.头条.链表和树;

import com.arithmetic.linkList.ListNode;

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

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            if (l1.next != null) {
                l1 = l1.next;
            } else {
                l1 = headB;
            }

            if (l2.next != null) {
                l2 = l2.next;
            } else {
                l2 = headA;
            }
        }
        return l1;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode currentA = headA, currentB = headB;
        int aindex = 0, bindex = 0;
        while (currentA != currentB) {
            currentA = (currentA != null) ? currentA.next : headB;
            currentB = (currentB != null) ? currentB.next : headA;

            if (currentA == headA) {
                aindex++;
            }
            if (currentB == headB) {
                bindex++;
            }
            if (aindex > 2 && bindex > 2) {
                return null;
            }
        }
        return currentA;
    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode currentA = headA, currentB = headB;
//        while (currentA != currentB) {
//            currentA = (currentA != null) ? currentA.next : headB;
//            currentB = (currentB != null) ? currentB.next : headA;
//        }

        while (currentA != currentB) {
            currentA = (currentA == null) ? headB : currentA.next;
            currentB = (currentB == null) ? headA : currentB.next;
        }

        return currentA;
    }


    //todo:如果两个链表不相交这段代码会死循环
    public ListNode getIntersectionNode4(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode currentA = headA, currentB = headB;
        while (currentA != currentB) {
            currentA = (currentA.next == null) ? headB : currentA.next;
            currentB = (currentB.next == null) ? headA : currentB.next;
        }

        return currentA;
    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(3);
//        ListNode head2 = new ListNode(2);
//        ListNode head3 = new ListNode(0);
//        ListNode head4 = new ListNode(4);
//        head.next = head2;
//        head2.next = head3;
//        head3.next = head4;
//
//
//        ListNode head5 = new ListNode(5);
//        head5.next = head3;
//
//
//        _160_相交链表 o = new _160_相交链表();
//        Asserts.test(o.getIntersectionNode2(head, head5).val == 0);

        ListNode head = new ListNode(3);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(0);
        ListNode head4 = new ListNode(4);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;


        ListNode head5 = new ListNode(3);
        ListNode head6 = new ListNode(2);
        ListNode head7 = new ListNode(0);
        ListNode head8 = new ListNode(4);
        head5.next = head6;
        head6.next = head7;
        head7.next = head8;


        _160_相交链表 o = new _160_相交链表();
//        System.out.println(o.getIntersectionNode3(head, head5));
        System.out.println(o.getIntersectionNode4(head, head5));
    }

}
