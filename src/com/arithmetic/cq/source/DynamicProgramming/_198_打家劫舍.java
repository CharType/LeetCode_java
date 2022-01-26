package com.arithmetic.cq.source.DynamicProgramming;

import com.arithmetic.tools.Integers;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * <p>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * dp[i]  = 从dp[0]开始在不触发防盗系统的情况下偷到的最高值
 * 当前房间有两种情况 偷与不偷 取一个最大的值
 * 状态转移方程
 * dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
 * 什么时候偷，什么时候不偷
 * i = 0 的时候 必须偷 因为只有一个房间
 * i= 1 的时候 num[1] > num[0] 偷第二个房间否则不偷
 * 时间复杂度 O(n)
 * 空间复杂度 O(n)
 */
public class _198_打家劫舍 {
    static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i == 1) {
                if (nums[i] > nums[0]) {
                    dp[i] = nums[i];
                } else {
                    dp[i] = nums[i - 1];
                }
            } else {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
        }
        Integers.println(dp);
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
        int[] nums1 = {2, 1, 1, 2};
        System.out.println(rob1(nums1));
    }

    static int rob1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int old = first;
            first = second;
            second = Math.max(old + nums[i], second);

        }
        return second;
    }
}
