package com.探索.头条.数组;

/**
 * https://leetcode-cn.com/problems/friend-circles/
 */
public class _547_朋友圈 {

    public int findCircleNum(int[][] M) {
        if (M == null || M.length < 0) return 0;
        if (M.length == 1) return 1;
        int f = 0;
        for (int i = 0;i < M.length;i++) {
            for (int j = 0;j < M[0].length;j++) {
               int num = maxAreaOfIsland(M,i,j);
               if (num > 0) f++;
            }
        }
        return f;
    }

    public  int maxAreaOfIsland(int[][] grid,int i,int j) {
        if (grid[i][j] == 0) return 0;

        int value = 1;
        // 染色成0
        grid[i][j] = 0;

        if (j + 1 < grid[0].length) {
            value += maxAreaOfIsland(grid,i,j + 1);
        }

        if (j - 1 >= 0 && grid[i][j-1] == 1) {
            value += maxAreaOfIsland(grid,i,j-1);
        }

        if (i - 1 >= 0 && grid[i-1][j] == 1) {
            value += maxAreaOfIsland(grid,i-1,j);
        }

        if (i + 1 < grid.length) {
            value += maxAreaOfIsland(grid,i + 1,j);
        }

        return value;

    }

    public static void main(String[] args) {
        _547_朋友圈 o = new _547_朋友圈();
//        int [][] nums = {
//                {0,0,1,0,0,0,0,1,0,0,0,0,0},
//                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,1,1,0,1,0,0,0,0,0,0,0,0},
//                {0,1,0,0,1,1,0,0,1,0,1,0,0},
//                {0,1,0,0,1,1,0,0,1,1,1,0,0},
//                {0,0,0,0,0,0,0,0,0,0,1,0,0},
//                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,0,0,0,0,0,0,1,1,0,0,0,0}
//        };

//        int [][] nums = {
//                {0,1},
//                {1,1}
//        };
        int [][] nums = {
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}
        };
        System.out.println(o.findCircleNum(nums));

    }
}
