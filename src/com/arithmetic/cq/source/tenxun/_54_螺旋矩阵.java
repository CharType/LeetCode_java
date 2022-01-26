package com.arithmetic.cq.source.tenxun;

import java.util.ArrayList;
import java.util.List;

/**
 * 1    2   3
 * 4    5   6
 * 7    8   9
 */

public class _54_螺旋矩阵 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int top = 0, left = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }

            top++;

            for (int j = top; j <= bottom; j++) {
                list.add(matrix[j][right]);
            }
            right--;
            if (top > bottom || left > right) break;
            for (int k = right; k >= left; k--) {
                list.add(matrix[bottom][k]);
            }
            bottom--;

            for (int n = bottom; n >= top; n--) {
                list.add(matrix[n][left]);
            }
            left++;

        }
        return list;
    }

    public static void main(String[] args) {
        _54_螺旋矩阵 o = new _54_螺旋矩阵();
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        System.out.println(o.spiralOrder(matrix));
        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(o.spiralOrder(matrix2));
    }
}
