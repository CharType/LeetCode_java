package com.探索.腾讯.动态规划;

/**
 *https://leetcode-cn.com/explore/interview/card/tencent/226/dynamic-programming/936/
 */
public class 不同路径 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0;i < m;i++) {
            dp[i][0] = 1;
        }
        for (int i = 0;i < n;i++) {
            dp[0][i] = 1;
        }

        for (int i = 1;i < m;i++) {
            for (int j = 1;j < n;j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        不同路径 o = new 不同路径();
        System.out.println(o.uniquePaths(3,3));
    }
}
