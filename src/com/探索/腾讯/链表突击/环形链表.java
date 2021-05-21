package com.探索.腾讯.链表突击;

import com.linkList.ListNode;

/**
 * https://leetcode-cn.com/explore/interview/card/tencent/222/linked-list/916/
 */
public class 环形链表 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (slow != null && (fast != null && fast.next != null)) {
            if (slow == fast) return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    public static void main(String[] args) {
        环形链表 o = new 环形链表();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = head.next;
        System.out.println(o.hasCycle(head));

    }
}
