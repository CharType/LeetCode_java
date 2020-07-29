package com.头条高频算法题;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 */
public class _200_岛屿数量 {

    public int numIslands(char[][] grid) {
        if (grid == null) return 0;
        int maxValue = 0;
        int [][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1;i >= 0;i--) {
            for (int j = grid[0].length - 1;j >= 0;j--) {
                int isnum = 1;
                if (grid[i][j] == '0') {
                    isnum = 0;
                } else {
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        if (grid[i-1][j] == '0' && grid[i][j-1] == '0') {
                            isnum = 0;
                        }
                    }

                }


                maxValue = Math.max(maxValue,isnum);
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        _200_岛屿数量 o = new _200_岛屿数量();
//        char [][] chars = {
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'},
//        };
        char [][] chars = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'},
        };
        System.out.println(o.numIslands(chars));

    }
}
