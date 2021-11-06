package com.cq.source.list.leetcode;

import com.linkList.ListNode;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2]
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _234_回文链表 {

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        if (head.next.next == null) return head.val == head.next.val;
        // 快慢指针
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode centerNode = slow;

        ListNode rightNode = reversalList(slow.next);

        while (rightNode != null) {
            if (head.val != rightNode.val) {
                return false;
            }
            rightNode = rightNode.next;
            head = head.next;
        }


        // 快指针到达终点 慢指针正好停在中间节点
        // 反转右边的链表
        // 比较两个链表是否相等
        return true;
    }


    public static boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) return true;
        if (head.next.next == null) return head.val == head.next.val;
        // 反转链表
        //todo 反转链表破坏了原来链表的结构，所以比较会有问题
        ListNode newHead = reversalList(head);
        while (head != null) {
            if (head.val != newHead.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }

    // 使用栈数据结构来解决

    public static ListNode reversalList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = null;
        while (head != null) {
            ListNode tempNode = head.next;
            head.next = newHead;
            newHead = head;
            head = tempNode;
        }

        return newHead;
    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        System.out.println(reversalList(head));

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }
}
