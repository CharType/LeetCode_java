package com.arithmetic.探索.腾讯.动态规划;

/**
 * https://leetcode-cn.com/explore/interview/card/tencent/226/dynamic-programming/921/
 */
public class 爬楼梯 {
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int first = 1;
        int secnd = 2;
        for (int i = 3;i <= n;i++) {
            secnd = secnd + first;
            first = secnd - first;
        }
        return secnd;
    }

    public int climbStairs2(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int [] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2;i < n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        爬楼梯 o = new 爬楼梯();
        System.out.println(o.climbStairs2(10));
    }
}
