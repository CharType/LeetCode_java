package com.头条高频算法题;

import com.linkList.ListNode;
import com.tools.Integers;

import java.util.PriorityQueue;

public class _206_反转链表 {

//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) return head;
//
//        ListNode newHead = null;
//        while (head != null) {
//            ListNode tempNode = head.next;
//            head.next = newHead;
//            newHead = head;
//            head = tempNode;
//        }
//        return newHead;
//
//    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = null;
        reverseList2(head,newHead);
        return newHead;

    }

    public ListNode reverseList2(ListNode head,ListNode newHead) {
//        if (head == null || head.next == null) return head;
//
//        ListNode temphead = reverseList2(head.next,newHead);
//        temphead.next = head;
//        ListNode node = temphead;
        return null;

    }

    public int [] suprofixMaxValue(Integer [] nums,int n) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int len = nums.length;
        for (int i = 0;i < len;i++) {
            if (queue.size() < n) {
                queue.add(nums[i]);
            } else  {
                if (nums[i] > queue.peek()) {
                    queue.remove();
                    queue.add(nums[i]);
                }
            }
        }

        System.out.println("前"+n+"大的数是：");
        while (!queue.isEmpty()) {
            Integer num = queue.remove();
            System.out.println(num);
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//
        _206_反转链表 o = new _206_反转链表();
//        System.out.println(o.reverseList1(head));

        Integer [] nums = Integers.random(100,0,100);
        o.suprofixMaxValue(nums,10);
    }

}
