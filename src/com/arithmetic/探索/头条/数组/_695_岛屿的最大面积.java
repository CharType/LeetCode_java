package com.arithmetic.探索.头条.数组;

public class _695_岛屿的最大面积 {
    public int maxValue = 0;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) return 0;
        for (int i = 0;i < grid.length;i++) {
            for (int j = 0;j < grid[0].length;j++) {
                maxAreaOfIsland(grid,i,j);
            }
        }
        return this.maxValue;
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

        this.maxValue = Math.max(this.maxValue,value);
        return value;

    }

    public static void main(String[] args) {
        _695_岛屿的最大面积 o = new _695_岛屿的最大面积();
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

        int [][] nums = {
                {0,1},
                {1,1}
        };
        System.out.println(o.maxAreaOfIsland(nums));

    }
}
