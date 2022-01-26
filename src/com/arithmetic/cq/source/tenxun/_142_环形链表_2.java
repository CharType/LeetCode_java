package com.arithmetic.cq.source.tenxun;

import com.arithmetic.linkList.ListNode;

import java.util.HashSet;
import java.util.Set;

public class _142_环形链表_2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
