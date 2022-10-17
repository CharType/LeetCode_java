package com.arithmetic.cq.source.tenxun;

import com.arithmetic.tools.Integers;

public class _59_螺旋矩阵2 {
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int top = 0, left = 0, right = n - 1, bottom = n - 1;
        int res = 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                nums[top][i] = res++;
            }
            top++;
            for (int j = top; j <= bottom; j++) {
                nums[j][right] = res++;
            }
            right--;

            if (top > bottom || left > right) break;

            for (int k = right; k >= left; k--) {
                nums[bottom][k] = res++;
            }
            bottom--;

            for (int l = bottom; l >= top; l--) {
                nums[l][left] = res++;
            }
            left++;
        }
        return nums;
    }

    public static void main(String[] args) {
        _59_螺旋矩阵2 o = new _59_螺旋矩阵2();
        Integers.printNums(o.generateMatrix(3));
    }
}
