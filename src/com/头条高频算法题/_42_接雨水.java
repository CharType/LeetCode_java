package com.头条高频算法题;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class _42_接雨水 {
    public int trap(int[] height) {
        if (height == null || height.length <=2) return 0;
        // 存储每个高度左边的最大值
        int [] leftMaxValue  = new int[height.length];
        // 存储每个高度右边对应的最大值
        int [] rightMaxValue  = new int[height.length];
        for (int i = 1;i< height.length;i++) {
            leftMaxValue[i] = Math.max(leftMaxValue[i - 1], height[i - 1]);
        }
        for (int j = height.length - 2;j >= 0;j--) {
            rightMaxValue[j] = Math.max(rightMaxValue[j+1],height[j+1]);
        }
        // 统计可以接到多少雨水
        int sum = 0;
        for (int i = 0;i < height.length;i++) {
            int leftHeight = leftMaxValue[i];
            int rightHeight = rightMaxValue[i];
            int minHeight =  Math.min(leftHeight, rightHeight);
            int currrentHeight = height[i];
            if(minHeight > currrentHeight) {
                sum += minHeight - currrentHeight;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        _42_接雨水 o = new _42_接雨水();
        int [] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(o.trap(nums));
    }
}
