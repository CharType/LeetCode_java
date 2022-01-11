package com.cq.source.list.leetcode;

import com.linkList.ListNode;

import java.util.Stack;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _92_反转链表II {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode preNode = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            preNode = preNode.next;
        }
        ListNode cur = preNode.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = preNode.next;
            preNode.next = next;
        }
        return dummyNode.next;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = null;
        while (head != null) {
            ListNode node = head.next;
            head.next = newHead;
            newHead = head;
            head = node;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        _92_反转链表II o = new _92_反转链表II();
        System.out.println(o.reverseBetween(head, 2, 4));

//        ListNode head = new ListNode(3);
//        head.next = new ListNode(5);
//        _92_反转链表II o = new _92_反转链表II();
//
//        System.out.println(o.reverseBetween(head, 1, 2));

    }

    public ListNode reverseBetween1(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(-1);
        ListNode tempNode = newHead;
        boolean isReverse = false;
        while (head != null) {
            if (head.val == left) {
                isReverse = true;
            }

            if (isReverse) {
                Stack<ListNode> stack = new Stack<>();
                ListNode node = head;
                while (node != null) {
                    stack.push(node);
                    node = node.next;
                    if (node.val == right) {
                        stack.push(node);
                        head = node.next;
                        isReverse = false;
                        break;
                    }
                }
                while (!stack.isEmpty()) {
                    tempNode.next = stack.pop();
                    tempNode = tempNode.next;
                }
            } else {
                tempNode.next = head;
                tempNode = tempNode.next;
                head = head.next;
            }
        }
        return newHead.next;

    }
}
