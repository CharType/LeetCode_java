package com.探索.头条.数组;

import java.util.PriorityQueue;

public class _215_数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || k < 0) return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(( o1, o2) -> o1 - o2);
        for (int i = 0;i < nums.length;i++) {
            queue.add(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
    public static void main(String[] args) {
        _215_数组中的第K个最大元素 o = new _215_数组中的第K个最大元素();
        int [] nums = {3,2,1,5,6,4};
        System.out.println(o.findKthLargest(nums,2));
    }
}
