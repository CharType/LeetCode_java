package shudu;

public class ShuDu3 {
    private int[][] board;      // 数独矩阵
    private int zeroNum;            // 缺失的数字个数
    private int filledNum;  // 已填充的数字个数
    public int[][] result;      // 填充后的最终结果

    public ShuDu3(int[][] board) {
        this.board = board;

        zeroNum = getZeroNum();
        filledNum = 0;
        result = new int[9][9];
    }

    /**
     * 计算缺失的数字个数
     *
     * @return
     */
    private int getZeroNum() {
        int num = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    num++;
                }
            }
        }

        return num;
    }

    /**
     * 递归调用，填充缺失的数组。如果填充完毕，返回-1.否则，返回0。
     */
    public int search() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] > 0) {
                    continue;
                }

                int[] nums = getLegalNumbers(i, j);
                for (int k = 1; k <= 9; k++) { // 这个for循环，类似于象棋中搜索了一层。
                    if (nums[k] > 0) {
                        board[i][j] = k;
                        filledNum++;
                        if (filledNum >= zeroNum) {
                            // 缺失数字全部填充完毕
                            copyResult();
                            return -1;
                        }
                        if (search() == -1) {
                            return -1;
                        }
                        board[i][j] = 0;
                        filledNum--;
                    }
                }
                return 0;
            }
        }

        return 0;
    }

    /**
     * 返回某位置可以填的数字
     */
    private int[] getLegalNumbers(int i, int j) {
        int[] result = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        // 保证第i行不重复
        for (int k = 0; k < 9; k++) {
            if (board[i][k] > 0) {
                result[board[i][k]] = 0;
            }
        }

        // 保证第j列不重复
        for (int k = 0; k < 9; k++) {
            if (board[k][j] > 0) {
                result[board[k][j]] = 0;
            }
        }

        // 保证9宫格不重复
        for (int m = (i / 3) * 3; m < (i / 3 + 1) * 3; m++) {
            for (int n = (j / 3) * 3; n < (j / 3 + 1) * 3; n++) {
                if (board[m][n] > 0) {
                    result[board[m][n]] = 0;
                }
            }
        }

        return result;
    }

    private void copyResult() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                result[i][j] = board[i][j];
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 5, 1, 0, 0, 2, 0},
                {3, 2, 6, 0, 4, 8, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 3, 0},

                {0, 6, 0, 0, 0, 0, 9, 0, 0},
                {8, 0, 9, 0, 6, 0, 2, 0, 1},
                {0, 0, 1, 0, 0, 0, 0, 4, 0},

                {0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 2, 8, 0, 4, 5, 9},
                {0, 8, 0, 0, 5, 9, 0, 0, 0}
        };

        ShuDu3 myShuDu = new ShuDu3(board);
        myShuDu.search();
        int[][] result = myShuDu.result;
        for (int i = 0; i < 9; i++) {
            String str = "";
            for (int j = 0; j < 9; j++) {
                str = str + result[i][j] + ",";
            }
            System.out.println(str);
        }
    }
}
