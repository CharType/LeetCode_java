package com.cq.source.剑指Offer第二版;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 剑指Offer04_二维数组中的查找 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (target == matrix[i][j]) return true;
            }
        }
        return false;
    }

    //第二种思路没有想好，有错误
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (target == matrix[i][j]) return true;
                if (target > matrix[i][j] && j < matrix[i].length - 1 && i < matrix.length - 1) {
                    if (matrix[i][j + 1] >= matrix[i + 1][j]) {
                        j++;
                    } else {
                        i++;
                    }
                    if (target == matrix[i][j]) return true;
                }

                if (target < matrix[i][j] && j > 0 && j > 0) {
                    if (matrix[i][j - 1] >= matrix[i - 1][j]) {
                        j--;
                    } else {
                        i--;
                    }
                    if (target == matrix[i][j]) return true;
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
//        };

        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        剑指Offer04_二维数组中的查找 o = new 剑指Offer04_二维数组中的查找();
        System.out.println(o.findNumberIn2DArray2(matrix, 5));
    }
}
