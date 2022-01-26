package com.arithmetic.探索.腾讯.数组和字符串;

/**
 * https://leetcode-cn.com/explore/interview/card/tencent/221/array-and-strings/903/
 */
public class 盛最多水的容器 {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2)return 0;
        int left = 0;
        int right = height.length - 1;
        int value = 0;
        while (left <= right) {
            if (height[left] >= height[right]) {
                value = Math.max(value,(right - left) * height[right]);
                right--;
            } else {
                value = Math.max(value,(right - left) * height[left]);
                left++;
            }
        }
        return value;
    }

    public static void main(String[] args) {
        盛最多水的容器 o = new 盛最多水的容器();
//        int [] nums = {1,8,6,2,5,4,8,3,7};
        int [] nums = {1,1};
        System.out.println(o.maxArea(nums));
    }
}
