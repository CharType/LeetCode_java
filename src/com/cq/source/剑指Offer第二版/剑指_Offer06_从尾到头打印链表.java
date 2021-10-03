package com.cq.source.剑指Offer第二版;

import com.linkList.ListNode;
import com.tools.Integers;

import java.util.ArrayList;

public class 剑指_Offer06_从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[]{};
        if (head.next == null) return new int[]{head.val};
        ArrayList<Integer> list = new ArrayList<>();
        reversePrint(head, list);
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public void reversePrint(ListNode head, ArrayList list) {
        if (head.next != null) {
            reversePrint(head.next, list);
        }

        list.add(head.val);

    }

    public int[] reversePrint2(ListNode head) {
        if (head == null) return new int[]{};
        if (head.next == null) return new int[]{head.val};
        int count = 0;
        ListNode node = head;
        while (node.next != null) {
            count++;
            node = node.next;
        }
        int[] nums = new int[count + 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            nums[i] = head.val;
            head = head.next;
        }
        return nums;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Integers.println(new 剑指_Offer06_从尾到头打印链表().reversePrint2(head));
    }
}
