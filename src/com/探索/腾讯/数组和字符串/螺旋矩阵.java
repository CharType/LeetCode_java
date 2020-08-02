package com.探索.腾讯.数组和字符串;


import com.tools.Integers;

import java.util.ArrayList;
import java.util.List;

/**
 *https://leetcode-cn.com/explore/interview/card/tencent/221/array-and-strings/912/
 */
public class 螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
        int top = 0,left = 0;
        int right = matrix[0].length - 1;
        int bottm = matrix.length - 1;
        List<Integer> list = new ArrayList<>();
        while (top <= bottm && left <= right) {
            for (int i = left;i <= right;i++) {
               list.add(matrix[top][i]);
            }
            top++;


            for (int i = top;i <= bottm;i++) {
                list.add(matrix[i][right]);
            }
            right--;

            if (top > bottm || left > right) break;

            for (int i = right;i >= left;i--) {
                list.add(matrix[bottm][i]);
            }
            bottm--;

            for (int i = bottm;i >= top;i--) {
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        if (matrix == null || matrix[0].length == 0) return new ArrayList<>();
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
        螺旋矩阵 o = new 螺旋矩阵();
//        int[][] nums= {
//            {1, 2, 3, 4},
//            {5, 6, 7, 8},
//            {9,10,11,12}
//        };

//        int[][] nums= {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };

        int[][] nums= {
                {1, 2},
                {3, 4}
        };

        System.out.println(o.spiralOrder(nums));
        System.out.println(o.spiralOrder2(nums));
    }
}
