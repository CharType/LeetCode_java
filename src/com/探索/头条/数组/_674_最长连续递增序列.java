package com.探索.头条.数组;

/**
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 */
public class _674_最长连续递增序列 {

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int first = 1;
        int second = 1;

        int maxValue = first;
        for (int i = 1;i < nums.length;i++) {
            if (nums[i] > nums[i -1]) {
                second = first + 1;
            } else  {
                second = 1;
            }
            first = second;

            maxValue = Math.max(second,maxValue);
        }
        return maxValue;
    }

    // 滑动窗口
    public int findLengthOfLCIS1(int[] nums) {
        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i-1] >= nums[i]) anchor = i;
            ans = Math.max(ans, i - anchor + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        _674_最长连续递增序列 o = new _674_最长连续递增序列();
        int [] nums = {1,3,5,7};
//        int [] nums = {1};
        System.out.println(o.findLengthOfLCIS(nums));
    }


}
