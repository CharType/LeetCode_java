package com.arithmetic.探索.快手;

public class _72_编辑距离 {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        char [] char1s = word1.toCharArray();
        char [] char2s = word2.toCharArray();
        // 定义动态规划的数组，要比字符的长度加一
        int [][] dp = new int[char1s.length + 1][char2s.length + 1];
        // 初始化第一行和第一列的数据
        for (int i = 0;i <= char1s.length;i++) {
            dp[i][0] = i;
        }
        for (int i = 1;i <= char2s.length;i++) {
            dp[0][i] = i;
        }
        // 遍历循环 条件是小于等于length
        for (int i = 1;i <= char1s.length;i++) {
            for (int j = 1;j <= char2s.length;j++) {
                int left = dp[i-1][j] + 1;
                int top = dp[i][j-1] + 1;
                int leftTop = dp[i-1][j-1];
                // 取到左边的值和上面的值 都+1
                if (char1s[i -1] != char2s[j-1]) {
                    // 左上的值如果不相等，可以直接替换，否则还是左上的值
                    leftTop++;
                }
                // 取最小的值
                dp[i][j] = Math.min(left,Math.min(top,leftTop));
            }
        }
        return dp[char1s.length][char2s.length];
    }

    public static void main(String[] args) {
        _72_编辑距离 o = new _72_编辑距离();
//        System.out.println(o.minDistance("abcdef","abcdei"));
//        System.out.println(o.minDistance("horse","ros"));
        System.out.println(o.minDistance("","a"));
    }
}
