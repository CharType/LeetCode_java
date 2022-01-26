package com.arithmetic.探索.头条.数组;

public class _11_盛最多水的容器 {

    public int maxArea(int[] height) {
        if (height == null || height.length == 1) return 0;
        int left = 0;
        int right = height.length - 1;
        int maxValue = 0;
        while (left < right) {
            int rightValue = height[right];
            int leftValue = height[left];
            maxValue = Math.max(maxValue,(right - left) * Math.min(leftValue,rightValue));
            if (leftValue > rightValue) {
                right--;
                while (rightValue > height[right] && left < right) right--;
            } else {
                left++;
                while (leftValue > height[left] && left < right) left++;
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
