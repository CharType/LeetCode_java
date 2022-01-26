package com.arithmetic.探索.头条.动态规划;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class _64_最小路径和 {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int [][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        int rows = grid.length;
        int clos = grid[0].length;
        for (int i = 1;i < rows;i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i = 1;i < clos;i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for (int i = 1;i < rows;i++) {
            int [] nums = grid[i];
            for (int j = 1;j < clos;j++) {
                dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j]) + grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    };

    public static void main(String[] args) {
        _64_最小路径和 o = new _64_最小路径和();
//        int [][] grid = {
//                {1,3,1},
//                {1,5,1},
//                {4,2,1}
//        };

        int [][] grid = {
                {0,1},
                {1,0}
        };

        System.out.println(o.minPathSum(grid));
    }
}
