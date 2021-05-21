package com.探索.快手;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-arithmetic-sequence/
 */
public class _1027_最长等差数列 {

    public int longestArithSeqLength(int[] A) {
        if (A == null || A.length < 2) {
            return 0;
        }
        int res = 2;
        Map<Integer,Integer>[] dp = new HashMap[A.length];
        for (int i = 0;i < A.length;i++) {
            dp[i] = new HashMap<>();
            for (int j = 0;j < i;j++) {
                int diff = A[i] - A[j];
                // 如果j的前面也存在diff 的等差序列，就把它加上
                if (dp[j].containsKey(diff)) {
                    dp[i].put(diff,dp[j].get(diff) + 1);
                } else {
                    dp[i].put(diff,2);
                }
                res = Math.max(res,dp[i].get(diff));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _1027_最长等差数列 o = new _1027_最长等差数列();
        int [] nums = {3,6,9,12};
        System.out.println(o.longestArithSeqLength(nums));
    }
}
