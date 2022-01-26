package com.arithmetic.linkList;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class _23_合并K个排序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
      if (lists == null) return null;
      if (lists.length == 1) return lists[0];
      PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((ListNode l1,ListNode l2) -> l1.val - l2.val);
      ListNode head = new ListNode(-1);
      ListNode newHead = head;
      for (int i = 0; i < lists.length ; i++) {
          if (lists[i] != null) {
              queue.add(lists[i]);
          }
      }
      while (!queue.isEmpty()) {
          ListNode temp = queue.poll();
          head.next = temp;
          head = head.next;
          if (temp.next != null) {
              queue.add(temp.next);
          }

      }
      return newHead.next;
    }

    public static void main(String[] args) {
        _23_合并K个排序链表 o = new _23_合并K个排序链表();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);
        ListNode [] lists = {head1,head2,head3};
        System.out.println(o.mergeKLists(lists));

    }
}
