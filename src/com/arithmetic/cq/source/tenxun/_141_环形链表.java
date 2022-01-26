package com.arithmetic.cq.source.tenxun;

import com.arithmetic.linkList.ListNode;

public class _141_环形链表 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fastNode = head.next;
        ListNode slowNode = head;
        while (slowNode != null && (fastNode != null && fastNode.next != null)) {
            if (fastNode == slowNode) {
                return true;
            }
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        return false;
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
        _141_环形链表 o = new _141_环形链表();
        System.out.println(o.hasCycle(head));
    }
}
