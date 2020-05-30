package com.高频题;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class _11_盛最多水的容器 {

    public int maxArea1(int[] height) {
        if (height == null || height.length <= 2) return 0;
        int left = 0;
        int right = height.length - 1;
        int maxArge = 0;
        while (left < right) {
            int leftValue = height[left];
            int rightValue = height[right];
            maxArge = Math.max(maxArge,(right - left) * Math.min(leftValue, rightValue));
            if (leftValue > rightValue) {
                right--;
                while (rightValue > height[right] && left < right){ right--;}

            } else {
                left++;
                while (leftValue > height[left] && left < right){ left++;}
            }

        }
        return maxArge;
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     */
    public int maxArea(int[] height) {
        if (height == null || height.length <= 2) return 0;
        int left = 0;
        int right = height.length - 1;
        int maxArge = 0;
        while (left < right) {
            maxArge = Math.max(maxArge,(right - left) * Math.min(height[left],height[right]));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }

        }
        return maxArge;
    }

    public static void main(String[] args) {
        _11_盛最多水的容器 o = new _11_盛最多水的容器();
        int [] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(o.maxArea1(nums));

    }
}
