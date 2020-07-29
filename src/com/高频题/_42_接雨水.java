package com.高频题;

import com.tools.Integers;

/**
 *https://leetcode-cn.com/problems/trapping-rain-water/
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 */
public class _42_接雨水 {

    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int [] leftMaxValues = new int[height.length];
        int lastIndex = height.length - 2;
        // 获得左边最大的数字
        for (int i = 1; i <= lastIndex; i++) {
            leftMaxValues[i] = Math.max(height[i-1],leftMaxValues[i-1]);
        }
        // 获得右边最大的数字
        int [] rightMaxValues = new int[height.length];
        for (int i = lastIndex; i >=1; i--) {
            rightMaxValues[i] = Math.max(height[i+1],rightMaxValues[i+1]);
        }
        Integers.println(leftMaxValues);
        Integers.println(rightMaxValues);
        // 能存多少水等于最小的那个数字减去自己的高度
        int sum = 0;
        for (int i = 1;i <= lastIndex; i++) {
            int minValue = Math.min(leftMaxValues[i], rightMaxValues[i]);
            if (minValue > height[i]) {
                sum += minValue - height[i];
            }
        }
            return sum;
    }

    public int trap1(int[] height) {
        if (height == null || height.length == 0) return 0;
        int lastIndex = height.length - 2;
        // 获得右边最大的数字
        int [] rightMaxValues = new int[height.length];
        for (int i = lastIndex; i >=1; i--) {
            rightMaxValues[i] = Math.max(height[i+1],rightMaxValues[i+1]);
        }

        // 能存多少水等于最小的那个数字减去自己的高度
        int sum = 0;
        int leftMax = 0;
        for (int i = 1;i <= lastIndex; i++) {
            leftMax = Math.max(height[i-1],leftMax);
            int minValue = Math.min(leftMax, rightMaxValues[i]);
            if (minValue > height[i]) {
                sum += minValue - height[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        _42_接雨水 o = new _42_接雨水();
        int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//        int [] height = {2,0,2};
        System.out.println(o.trap(height));
    }
}
