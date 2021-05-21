package com.探索.腾讯.数组和字符串;

/**
 * https://leetcode-cn.com/explore/interview/card/tencent/221/array-and-strings/913/
 */
public class 螺旋矩阵II {
    public int[][] generateMatrix(int n) {
        if (n <= 0) return new int[0][0];
        int [][] ans = {{1}};
        if (n == 1) return ans;
        int [][] matrix = new int[n][n];
        int top = 0,left = 0;
        int right = n - 1;
        int bottom = n - 1;
        int value = 1;
        while (top <= bottom && left <= right) {
            for (int i = left;i <= right;i++) {
                matrix[top][i] = value++;
            }
            top++;

            for (int i = top;i <= bottom;i++) {
                matrix[i][right] = value++;
            }
            right--;

            if (left > right || top > bottom) break;

            for (int i = right;i>= left;i--) {
                matrix[bottom][i] = value++;
            }
            bottom--;

            for (int i = bottom;i >= top;i--) {
                matrix[i][left] = value++;
            }
            left++;
        }
        return matrix;

    }

    public static void main(String[] args) {
        螺旋矩阵II o = new 螺旋矩阵II();
        int [][] nums = o.generateMatrix(3);
        螺旋矩阵 o1 = new 螺旋矩阵();
        System.out.println(o1.spiralOrder(nums));
//        for (int i =0;i < nums.length;i++) {
//            for (int j = 0;j < nums[i].length;j++) {
//                System.out.print(nums[i][j]);
//            }
//            System.out.println();
//
//        }
    }
}
