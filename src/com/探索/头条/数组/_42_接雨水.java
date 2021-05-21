package com.探索.头条.数组;

public class _42_接雨水 {
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        int [] leftMax = new int[height.length];
        int [] rightMax = new int[height.length];
        for (int i = 1;i <= height.length - 2 ;i++) {
            leftMax[i] = Math.max(height[i-1],leftMax[i-1]);
        }

        for (int i = height.length-2;i >= 1;i--) {
            rightMax[i] = Math.max(height[i+1],rightMax[i+1]);
        }

        int result = 0;
        for (int i = 1;i <= height.length - 2;i++) {

            int minval = Math.min(leftMax[i],rightMax[i]);
            if (minval > height[i]) {
                result += minval - height[i];;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _42_接雨水 o = new _42_接雨水();
        int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//        int [] height = {2,0,2};
        System.out.println(o.trap(height));
    }
}
