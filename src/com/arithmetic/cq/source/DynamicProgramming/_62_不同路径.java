package com.arithmetic.cq.source.DynamicProgramming;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 定义状态
 * dp[i][j] = 从dp[0][0]走到当前dp[i][j]位置的不同路径数
 * dp[i][j] = dp[i-1][j] + dp[i][j-1];
 */
public class _62_不同路径 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths(3, 3));
    }

    static int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return 1;
        int[][] dp = new int[m][n];
        // 初始化
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
