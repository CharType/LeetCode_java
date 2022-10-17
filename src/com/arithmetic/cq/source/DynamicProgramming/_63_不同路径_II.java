package com.arithmetic.cq.source.DynamicProgramming;

public class _63_不同路径_II {
    static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length <= 0 || obstacleGrid[0].length <= 0) return 0;
        int n = obstacleGrid[0].length;
        int m = obstacleGrid.length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;
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
                if (obstacleGrid[i - 1][j] != 1 && obstacleGrid[i][j - 1] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    if (obstacleGrid[i - 1][j] == 1) {
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }

            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
