package com.探索.头条.数组;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class _378_有序矩阵中第K小的元素 {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int index = 0;
        for (int i = 0;i < matrix.length;i++) {
            for (int j = 0;j < matrix[i].length;j++) {
                if (index == k -1) {
                    return matrix[i][j];
                }
                index++;
            }
        }
        return -1;

//        int sum = matrix.length * matrix[0].length;
//        if (k > sum) return -1;
//        int clo = k / matrix[0].length - 1;
//        int row = k % matrix[0].length - 1;
//        return matrix[clo][row];
    }

    public static void main(String[] args) {
        _378_有序矩阵中第K小的元素 o = new _378_有序矩阵中第K小的元素();
//        int[][] matrix = {
//                {1,5,9},
//                {10, 11, 13},
//                {12, 13, 15}
//             };

        int[][] matrix = {
                {-5}
        };
        System.out.println(o.kthSmallest(matrix,1));

    }
}
