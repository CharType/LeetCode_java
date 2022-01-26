package com.arithmetic.每日一题;

import com.arithmetic.tools.Integers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 */
public class _面试题29_顺时针打印矩阵 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null) return null;
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) return new int[0];
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

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] spiralOrder1(int[][] matrix) {
        if (matrix == null) return null;
        if (matrix.length == 0) return new int[0];
        int length = matrix.length * matrix[0].length;
        int [] list = new int[length];
        int left = 0,top = 0;
        int right = matrix[0].length-1;
        int bottom = matrix.length -1;
        int x = 0;
        while (top <= bottom && left<= right) {
            for (int i = left ;i <= right ;i++) {
                list[x++] = matrix[top][i];
            }
            top++;
            for (int i = top ;i <= bottom ;i++) {
                list[x++] = matrix[i][right];
            }
            right--;
            if (top > bottom || left > right) break;
            for (int i = right ;i >= left ;i--) {
                list[x++] = matrix[bottom][i];
            }
            bottom--;

            for (int i = bottom ;i >= top ;i--) {
                list[x++]= matrix[i][left];
            }
            left++;
        }

        return list;
    }

    public static void main(String[] args) {
        _面试题29_顺时针打印矩阵 o = new _面试题29_顺时针打印矩阵();
        int [][] nums = {{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12}};
        Integers.println(o.spiralOrder1(nums));
    }
}
