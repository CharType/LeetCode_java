package com.cq.source.DynamicProgramming;

/**
 * 给定两个字符串text1 和text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * <p>
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * dp[i][j] 是第一个text前i个元素和第二个text前j个元素最长公共子序列的长度
 * dp[i][0] he dp[0][j] 的初始值都是0
 * 如果test1[i-1] == text2[j-1] 那么 dp[i][j] = dp[i-1][j-1] + 1;
 * 如果test1[i-1] != text2[j-1] 那么 dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
 */
public class _1143_最长公共子序列 {

    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int ilength = chars1.length + 1;
        int jlength = chars2.length + 1;
        int[][] dp = new int[ilength][jlength];
        for (int i = 1; i < ilength; i++) {
            for (int j = 1; j < jlength; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[ilength - 1][jlength - 1];
    }

    public static void main(String[] args) {
//        System.out.println(longestCommonSubsequence("abcdefghjkilmn", "abcdefqweyeuiei"));
//        System.out.println(lcs(new int[]{1, 2, 3, 4, 5, 6, 7, 9}, new int[]{1, 2, 3, 4, 5, 9, 10}));
        System.out.println(longestCommonSubsequence1("abcde", "ace"));
        System.out.println(longestCommonSubsequence2("abcde", "ace"));
    }

    static int lcs(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return 0;
        if (nums2 == null || nums2.length == 0) return 0;
        return lcs(nums1, nums1.length, nums2, nums2.length);
    }

    /**
     * 求nums1前i个元素和nums2前j个元素的最长公共子序列长度
     *
     * @param nums1
     * @param i
     * @param nums2
     * @param j
     * @return
     */
    static int lcs(int[] nums1, int i, int[] nums2, int j) {
        if (i == 0 || j == 0) return 0;
        if (nums1[i - 1] == nums2[j - 1]) {
            return lcs(nums1, i - 1, nums2, j - 1) + 1;
        }
        return Math.max(lcs(nums1, i - 1, nums2, j), lcs(nums1, i, nums2, j - 1));
    }

    public static int longestCommonSubsequence1(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[] dp = new int[chars2.length + 1];
        for (int i = 1; i <= chars1.length; i++) {
            int cur = 0;
            for (int j = 1; j <= chars2.length; j++) {
                int leftTop = cur;
                cur = dp[j];
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[j] = leftTop + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
            }
        }
        return dp[chars2.length];
    }

    public static int longestCommonSubsequence2(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        char[] rowsChars = chars1;
        char[] colsChars = chars2;
        if (chars1.length < chars2.length) {
            colsChars = chars1;
            rowsChars = chars2;
        }
        int[] dp = new int[colsChars.length + 1];
        for (int i = 1; i <= rowsChars.length; i++) {
            int cur = 0;
            for (int j = 1; j <= colsChars.length; j++) {
                int leftTop = cur;
                cur = dp[j];
                if (rowsChars[i - 1] == colsChars[j - 1]) {
                    dp[j] = leftTop + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
            }
        }
        return dp[colsChars.length];
    }
}
