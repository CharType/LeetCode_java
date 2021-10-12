package com.cq.source.剑指Offer第二版;


import com.tools.Integers;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、
 * 直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof
 * dp[i][j] 表示 从dp[0][0] 走到dp[i][j] 可以获得的礼物的最大价值
 * dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
 */
public class 剑指Offer_47_礼物的最大价值 {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(maxValue(grid));
        System.out.println("-----------------------------------------------");
        System.out.println(maxValue1(grid));
        System.out.println("-----------------------------------------------");
        System.out.println(maxValue2(grid));
    }

    public static int maxValue2(int[][] grid) {
        if (grid == null || grid[0] == null || grid[0].length == 0) return 0;
        int[] dp = new int[grid[0].length];
        dp[0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
        Integers.println(dp);
        for (int i = 1; i < grid.length; i++) {
            int[] nums = grid[i];
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < nums.length; j++) {
                dp[j] = Math.max(dp[j] + grid[i][j], dp[j - 1] + grid[i][j]);
            }
            Integers.println(dp);
        }


        return dp[grid[0].length - 1];
    }

    public static int maxValue1(int[][] grid) {
        if (grid == null || grid[0] == null || grid[0].length == 0) return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid.length; i++) {
            int[] nums = grid[i];
            for (int j = 1; j < nums.length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        printf(dp);

        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static int maxValue(int[][] grid) {
        if (grid == null || grid[0] == null || grid[0].length == 0) return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            int[] nums = grid[i];
            for (int j = 0; j < nums.length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    if (i == 0) {
                        dp[i][j] = dp[i][j - 1] + grid[i][j];
                    } else if (j == 0) {
                        dp[i][j] = dp[i - 1][j] + grid[i][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                    }

                }

            }
        }
        printf(dp);
        return dp[grid.length - 1][grid[0].length - 1];
    }

    static void printf(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            Integers.println(dp[i]);
        }
    }
}
