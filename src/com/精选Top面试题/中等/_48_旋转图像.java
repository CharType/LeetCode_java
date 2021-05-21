package com.精选Top面试题.中等;

/**
 * https://leetcode-cn.com/problems/rotate-image/
 */
public class _48_旋转图像 {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) return;
        int left = 0,top = 0;
        int right = matrix[0].length - 1, bottom = matrix.length - 1;
        while (top <= bottom && left <= bottom) {
            int temp = right - left - 1;
            if (temp <= 0) break;
            int tempValue = matrix[top][left];
            while (temp >= 0) {

                for (int i = top;i < bottom;i++){
                    matrix[i][left] = matrix[i+1][left];
                }


                for (int i = left;i < right;i++) {
                    matrix[bottom][i] = matrix[bottom][i + 1];
                }



                for (int i = bottom;i > top;i-- ){
                    matrix[i][right] = matrix[i-1][right];
                }

                temp--;
                if (temp < 0) break;

                for (int i = right;i > left;i-- ){
                    matrix[top][i] = matrix[top][i-1];
                }


                System.out.println("----------------------------------");
                printNums(matrix);
            }
            matrix[top][right] = tempValue;
            left++;
            bottom--;
            right--;
            top++;
        }

    }

    public void rotate2(int[][] matrix) {
        int n = matrix.length;

        // 先左上角右下角对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // 翻转每一行的变量
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    public void printNums(int[][] nums) {
        for (int i = 0;i < nums.length;i++){
            for (int j = 0;j < nums[0].length;j++) {
                System.out.print(" ");
                System.out.print(nums[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        _48_旋转图像 o = new _48_旋转图像();
        int [][] nums = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println("原数据----------------------------------");
        o.printNums(nums);

        o.rotate2(nums);
        System.out.println("翻转之后数据----------------------------------");
        o.printNums(nums);
    }
}
