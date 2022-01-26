package com.arithmetic.腾讯精选练习;

/**
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class _11_盛最多水的容器 {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int li = 0, ri = height.length - 1;
        int maxValue = 0;
        while (li < ri) {
            int leftValue = height[li];
            int rightValue = height[ri];
            int minv = Integer.min(leftValue, rightValue);
            int value = (ri - li) * minv;
            maxValue = Integer.max(maxValue, value);
            if (leftValue < rightValue) {
                li++;
                while (leftValue < rightValue &&  leftValue > height[li]) li++;
            } else {
                ri--;
                while (leftValue < rightValue &&  rightValue > height[ri]) ri--;
            }
        }
        return maxValue;
    }
    public static void main(String[] args) {
        _11_盛最多水的容器 o = new _11_盛最多水的容器();
        int [] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(o.maxArea(nums));
    }
}
