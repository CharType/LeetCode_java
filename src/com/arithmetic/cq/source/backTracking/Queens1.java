package com.arithmetic.cq.source.backTracking;

// 八皇后题目
public class Queens1 {
    public static void main(String[] args) {
        new Queens1().placeQueens(8);
    }

    // 数组索引是行号，元素是列号
    int[] queens;
    /**
     * 标记着某一列是否有皇后
     */
    boolean[] cols;
    // 标记着某一斜线上是否有皇后（左上角 -> 右下角）
    boolean[] leftTop;
    //标记着某一斜线上是否有皇后（右上角 -> 左下角）
    boolean[] rightTop;
    //记录一共有多少种摆法
    int ways;

    void placeQueens(int n) {
        if (n < 1) return;
        queens = new int[n];
        cols = new boolean[n];
        leftTop = new boolean[(n << 1) - 1];
        rightTop = new boolean[leftTop.length];
        place(0);
        System.out.println(n + "皇后一共有" + ways + "种摆法");
    }

    void place(int row) {
        if (row == cols.length) {
            ways++;
            show();
            return;
        }
        for (int col = 0; col < cols.length; col++) {
            if (cols[col]) continue;
            int leftIndex = row + col;
            if (leftTop[leftIndex]) continue;
            int rightIndex = row - col + (cols.length - 1);
            if (rightTop[rightIndex]) continue;

            queens[row] = col;
            cols[col] = true;
            leftTop[leftIndex] = true;
            rightTop[rightIndex] = true;
            place(row + 1);

            cols[col] = false;
            leftTop[leftIndex] = false;
            rightTop[rightIndex] = false;
        }
    }


    void show() {
        for (int row = 0; row < cols.length; row++) {
            for (int col = 0; col < cols.length; col++) {
                if (queens[row] == col) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println("----------------------------------");
    }
}
