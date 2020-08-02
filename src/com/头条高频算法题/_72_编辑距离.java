package com.头条高频算法题;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 */
public class _72_编辑距离 {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        char [] chars1 = word1.toCharArray();
        char [] chars2 = word2.toCharArray();
        int [][] dp = new int[chars1.length+1][chars2.length+1];
        dp[0][0] = 0;
        for (int i = 1;i <= chars1.length;i++) {
            dp[i][0] = i;
        }
        for (int j = 1;j <= chars2.length;j++) {
            dp[0][j] = j;
        }
        for (int i = 1;i<=chars1.length;i++) {
            for (int j = 1;j<=chars2.length;j++) {
                int top = dp[i-1][j] + 1;
                int left = dp[i][j-1]+1;
                int leftTop = dp[i-1][j-1];
                if (chars1[i-1] != chars2[j-1]) {
                    leftTop++;
                }
                dp[i][j] = Math.min(Math.min(left,top),leftTop);
            }
        }

        return dp[chars1.length][chars2.length];
    }

    public static void main(String[] args) {
        _72_编辑距离 o = new _72_编辑距离();
//        System.out.println(o.minDistance("horseajshdkadhka","rosksjdhkahjaksdaks"));
        System.out.println(o.minDistance("","a"));
    }
}
