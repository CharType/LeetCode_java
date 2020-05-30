package com.高频题;

import com.tools.Integers;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class _215_数组中的第K个最大元素 {

    public int findKthLargest1(int[] nums, int k) {
        if (nums == null || nums.length < k) return -1;
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2) -> n1 - n2 );
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return  heap.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        if (nums == null || nums.length < k) return -1;
        int s = k;
        for (int end = nums.length - 1; end > 0; end--) {
            int max = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (nums[begin] > nums[max]) {
                    max = begin;
                }
            }
            s--;
            int temp = nums[max];
            nums[max] = nums[end];
            nums[end] = temp;
            if (s == 0) break;

        }
        return  nums[nums.length - k];
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) return -1;
        Arrays.sort(nums);
        int valueIndex = nums.length - k;
        for (int i = nums.length-1 ; i>= 0;i--) {
            if (valueIndex == i) return nums[i];
        }
        return  -1;
    }

    public static void main(String[] args) {
        _215_数组中的第K个最大元素 o = new _215_数组中的第K个最大元素();
        int [] nums = {3,2,1,5,6,4};
//        int [] nums = {2,1};
        System.out.println(o.findKthLargest2(nums,2));
//        Integers.println(nums);
    }
}
