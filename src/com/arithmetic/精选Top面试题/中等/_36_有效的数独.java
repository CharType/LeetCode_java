package com.arithmetic.精选Top面试题.中等;

/**
 * https://leetcode-cn.com/problems/valid-sudoku/
 */
public class _36_有效的数独 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0;i < board.length;i++) {
            for (int j = 0;j < board[0].length;j++) {
                boolean isR = isRowValidSudoku(board,i,j);
                boolean isC = isColValidSudoku(board,i,j);
                boolean isV = isValidSudoku(board,i,j);
                if (!(isR && isC && isV)) return false;
            }
        }
        return true;
    }

    // 判断在行上是否有效
    public boolean isRowValidSudoku(char[][] board,int x,int y) {
        if (board[x][y] == '.') return true;
        for (int i = 0;i < board[x].length;i++) {
            if (i == y) continue;
            if (board[x][i] == board[x][y]) {
                return false;
            }
        }
        return true;
    }

    // 判断在列上是否有效
    public boolean isColValidSudoku(char[][] board,int x,int y) {
        if (board[x][y] == '.') return true;
        for (int i = 0;i < board.length;i++) {
            if (i == x) continue;
            if (board[i][y] == board[x][y]) {
                return false;
            }
        }
        return true;
    }

    // 判断在当前九宫格中是否有效
    public boolean isValidSudoku(char[][] board,int x,int y) {
        if (board[x][y] == '.') return true;
        int row = y % 3;
        if (y - row <= 0) {
            row = 0;
        } else if(row == 0){
            row = y - 2;
        } else if (row == 2) {
            row = y - 1;
        } else if (row == 1) {
            row = y;
        }
        int clo = x % 3;
        if (x - clo <= 0) {
            clo = 0;
        } else if(clo == 0){
            clo = clo - 2;
        } else if (clo == 2) {
            clo = x - 1;
        } else if (clo == 1) {
            clo = x;
        }
        for (int i = clo;i < clo + 3;i++) {
            for (int j = row;j < row + 3;j++) {
                if (i != x && j != y) {
                    if (board[i][j] == board[x][y]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        char[][] chars = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        _36_有效的数独 o = new _36_有效的数独();
        System.out.println(o.isValidSudoku(chars));
    }


}
