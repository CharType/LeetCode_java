package com.stack;

import com.tools.Integers;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class _239_滑动窗口最大值 {

    /* 动态规划*/
    public int[] maxSlidingWindow2(int[] nums, int k) {

        return null;
    }

    /**
     * 暴力法
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) return null;
        if (k == 1) return nums;

        int [] rers = new int [nums.length - k + 1];
        for (int i = 0; i< rers.length; i++) {
            int k1 = 0;
            int maxValue = 0;
            while (k1 < k) {
                maxValue = Math.max(maxValue, nums[i+k1]);
                k1++;
            }
            rers[i] = maxValue;
        }
        return rers;
    }
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> deque = new LinkedList<Integer>();
        int ri = 0;
        int li = -2;
        int [] rers = new int [nums.length];
        while (ri < nums.length) {
            if (deque.isEmpty()) {
                deque.add(ri);
            } else if (nums[ri] > nums[deque.getLast()]){

            }

            ri++;
            li++;
        }
        return null;
    }

    public static void main(String[] args) {
        _239_滑动窗口最大值 o = new _239_滑动窗口最大值();
        int [] nums = {1,3,-1,-3,5,3,6,7};
        Integers.println(o.maxSlidingWindow1(nums,3));
    }
}
