package com.arithmetic.stack;

import com.arithmetic.tools.Integers;

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
        if (nums == null || k <= 0) return  new int[0];
        if (k == 1) return nums;
        Deque<Integer> deque = new LinkedList<>();
        int [] results = new int[nums.length - k + 1];

        for (int ri = 0;ri < nums.length;ri++) {
            // 只要队列尾部比当前值小，都删除
            while (!deque.isEmpty() && nums[ri] >= nums[deque.peekLast()]) {
                deque.removeLast();
            }
            // 将当前值添加到队列的尾部
            deque.addLast(ri);

            // 检查队列是否合法
            int li = ri - k + 1;
            if (li < 0) continue;

            if (deque.peekFirst() < li) {
                deque.removeFirst();
            }

            results[li] = nums[deque.peekFirst()];
        }
        return results;
    }

    public static void main(String[] args) {
        _239_滑动窗口最大值 o = new _239_滑动窗口最大值();
//        int [] nums = {1,3,-1,-3,5,3,6,7};
        int [] nums = {7,2,4};
        Integers.println(o.maxSlidingWindow(nums,2));
    }
}
