package com.arithmetic.other;

import com.arithmetic.linkList.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
 */
public class 面试题_0202返回倒数第k个节点 {

    public int kthToLast1(ListNode head, int k) {
        List<ListNode> arrays = new ArrayList<>();
        while (head != null) {
            arrays.add(head);
            head = head.next;
        }
        return arrays.get(arrays.size() - k).val;
    }

    public int kthToLast2(ListNode head, int k) {
        ListNode first = head;
        ListNode scod = head;
        while (k > 0) {
            scod = scod.next;
            k--;
        }
        while (scod != null) {
            scod = scod.next;
            first = first.next;
        }
        return first.val;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        面试题_0202返回倒数第k个节点 o  = new 面试题_0202返回倒数第k个节点();
        System.out.println(o.kthToLast2(head,2));
    }
}
