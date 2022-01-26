package com.arithmetic.探索.头条.动态规划;

/**
 * https://leetcode-cn.com/problems/maximal-square/
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 这是一个标准的动态规划题目 当前值是 左边，上面，和左上方的最小值 +1 递推来的
 *
 */
class _221_最大正方形 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int [][] dp = new int[matrix.length][matrix[0].length];
        int value = 0;

        for (int i = 0;i < matrix.length;i++) {
            for (int j = 0; j<matrix[0].length;j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                       dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;
                    }
                }
                value = Math.max(value,dp[i][j]);
            }
        }
        return value * value;
    }

    public static void main(String[] args) {
        _221_最大正方形 o = new _221_最大正方形();
//        char [][] nums = {
//                {'1','0','1','0','0'},
//                {'1','0','1','1','1'},
//                {'1','1','1','1','1'},
//                {'1','0','0','1','0'}
//        };

        char [][] nums = {
                {'0','0','0','1'},
                {'1','1','0','1'},
                {'1','1','1','1'},
                {'0','1','1','1'},
                {'0','1','1','1'}
        };
        System.out.println(o.maximalSquare(nums));
    }

}
