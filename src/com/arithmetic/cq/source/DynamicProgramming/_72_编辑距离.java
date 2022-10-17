package com.arithmetic.cq.source.DynamicProgramming;

/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _72_编辑距离 {
    // 优化成一维数组
    static int minDistance1(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        char[] chars1 = word1.toCharArray();
        if (chars1.length == 0) return 0;
        char[] chars2 = word2.toCharArray();
        if (chars2.length == 0) return 0;
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        // 初始化数据
        for (int i = 1; i <= chars2.length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= chars1.length; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                int value1 = dp[i][j - 1] + 1;
                int value2 = dp[i - 1][j] + 1;
                int minValue = Math.min(value1, value2);
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = Math.min(minValue, dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(minValue, dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[chars1.length][chars2.length];
    }

    static int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        char[] chars1 = word1.toCharArray();
        if (chars1.length == 0) return 0;
        char[] chars2 = word2.toCharArray();
        if (chars2.length == 0) return 0;
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        // 初始化数据
        for (int i = 1; i <= chars2.length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= chars1.length; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                int value1 = dp[i][j - 1] + 1;
                int value2 = dp[i - 1][j] + 1;
                int minValue = Math.min(value1, value2);
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = Math.min(minValue, dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(minValue, dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[chars1.length][chars2.length];
    }


    public static void main(String[] args) {
        System.out.println(minDistance("arise", "mice"));
    }
}
