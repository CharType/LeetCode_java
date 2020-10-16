package com.精选Top面试题.中等;

import com.tools.Integers;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/set-matrix-zeroes/
 */
public class _73_矩阵置零 {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        Set<Integer> rset = new HashSet<>();
        Set<Integer> cset = new HashSet<>();
        for (int i = 0;i < r;i++) {
            for (int j = 0;j < c;j++) {
                if (matrix[i][j] == 0) {
                    rset.add(i);
                    cset.add(j);
                }
            }
        }
        for (int i = 0;i < r;i++) {
            for (int j = 0;j < c;j++) {
                if (cset.contains(j) || rset.contains(i)) {
                    matrix[i][j] = 0;
                }
            }

        }
    }

    public static void main(String[] args) {
        _73_矩阵置零 o = new _73_矩阵置零();
        int [][] nums = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
//        o.setZeroes(nums);
//        Integers.printNums(nums);
        int [][] nums2 = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        o.setZeroes(nums2);
        Integers.printNums(nums2);
    }
}
