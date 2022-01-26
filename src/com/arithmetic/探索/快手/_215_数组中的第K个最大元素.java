package com.arithmetic.探索.快手;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class _215_数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null) return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0;i < nums.length;i++) {
            if (queue.isEmpty() || queue.size() < k) {
                queue.add(nums[i]);
            } else {
                if(queue.peek() < nums[i]) {
                    queue.remove();
                    queue.add(nums[i]);
                }
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
