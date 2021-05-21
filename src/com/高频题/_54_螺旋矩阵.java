package com.高频题;

import com.tools.Integers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix/
 */
public class _54_螺旋矩阵 {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) return null;
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) return list;
        int left = 0, top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        while (top <= bottom && left <= right) {

            for (int i = left ;i <= right ;i++) {
                list.add(matrix[top][i]);
            }
            top++;

            for (int i = top ;i <= bottom ;i++) {
                list.add(matrix[i][right]);
            }
            right--;

            if (top > bottom || left > right) break;

            for (int i = right ;i >= left ;i--) {
                list.add(matrix[bottom][i]);
            }
            bottom--;

            for (int i = bottom ;i >= top ;i--) {
                list.add(matrix[i][left]);
            }
            left++;

        }

        return list;
    }

    public static void main(String[] args) {
        _54_螺旋矩阵 o = new _54_螺旋矩阵();
        int [][] nums = {{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12}};
        System.out.println(o.spiralOrder(nums));
    }
}
