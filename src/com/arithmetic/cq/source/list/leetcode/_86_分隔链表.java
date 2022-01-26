package com.arithmetic.cq.source.list.leetcode;

import com.arithmetic.linkList.ListNode;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _86_分隔链表 {

    public static ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode dymnnLeftHead = new ListNode(-1);
        ListNode dymnnLeftTail = dymnnLeftHead;
        ListNode dymnnRightHead = new ListNode(-1);
        ListNode dymnnRightTail = dymnnRightHead;
        while (head != null) {
            if (head.val < x) {
                dymnnLeftTail.next = head;
                dymnnLeftTail = head;
            } else {
                dymnnRightTail.next = head;
                dymnnRightTail = head;
            }
            head = head.next;
        }
        // 这句代码不能少
        dymnnRightTail.next = null;
        // 拼接
        dymnnLeftTail.next = dymnnRightHead.next;
        return dymnnLeftHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        System.out.println(partition(head, 3));
    }
}
