package com.探索.头条.链表和树;

import com.linkList.ListNode;
import com.tools.Asserts;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class _142_环形链表_II {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        Set<ListNode> set = new HashSet<>();
        ListNode tempHead = head;
        while (tempHead != null) {
            if (set.contains(tempHead)) {
                return tempHead;
            }
            set.add(tempHead);
            tempHead = tempHead.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(0);
        ListNode head4 = new ListNode(4);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head2;
        _142_环形链表_II o = new _142_环形链表_II();
        Asserts.test(o.detectCycle(head).val == 2);




    }
}
