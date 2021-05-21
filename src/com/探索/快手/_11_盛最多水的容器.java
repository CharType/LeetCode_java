package com.探索.快手;

public class _11_盛最多水的容器 {
    public int maxArea(int[] height) {
        if (height == null || height.length == 1) return 0;
        int li = 0,ri = height.length - 1;
        int maxVal = 0;
        while (li < ri) {
            int leftValue = height[li];
            int rightValue = height[ri];
            maxVal = Math.max(maxVal,(ri - li) * Math.min(leftValue,rightValue));
            if (leftValue < rightValue) {
                li++;
                while (leftValue < rightValue && leftValue > height[li]) li++;
            } else {
                ri--;
                while (leftValue < rightValue && rightValue > height[ri]) ri--;
            }
        }
        return maxVal;
    }
    public static void main(String[] args) {
        _11_盛最多水的容器 o = new _11_盛最多水的容器();
        int [] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(o.maxArea(nums));
    }
}
