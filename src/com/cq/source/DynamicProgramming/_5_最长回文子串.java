package com.cq.source.DynamicProgramming;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * <p>
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ac"
 * 输出："a"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * dp[i][j] = 字符串以i开头 以j结尾的字符串是否是最长回文字符串
 */
public class _5_最长回文子串 {


    static String longestPalindrome(String s) {
        if (s == null) return null;
        char[] chars = s.toCharArray();
        if (chars.length == 0) return "";
        boolean[][] dp = new boolean[chars.length][chars.length];
        int maxLength = 0;
        int begin = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            for (int j = i; j < chars.length; j++) {
                int length = j - i + 1;
                dp[i][j] = chars[i] == chars[j] && (length <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && length > maxLength) {
                    maxLength = length;
                    begin = i;
                }
            }
        }
        return new String(chars, begin, maxLength);
    }

    /**
     * 扩展中心法
     *
     * @param s
     * @return
     */
    static String longestPalindrome2(String s) {
        if (s == null) return s;
        char[] chars = s.toCharArray();
        if (chars.length <= 1) return s;
        int maxLength = 1;
        int begin = 0;
        for (int i = chars.length - 2; i >= 1; i--) {
            int len1 = palindromeLength(chars, i - 1, i + 1);
            int len2 = palindromeLength(chars, i, i + 1);
            len1 = Math.max(len1, len2);
            if (len1 > maxLength) {
                maxLength = len1;
                begin = i - ((maxLength - 1) >> 1);
            }
        }

        if (chars[0] == chars[1] && maxLength < 2) {
            maxLength = 2;
            begin = 0;
        }

        return new String(chars, begin, maxLength);
    }

    /**
     * 扩展中心优化
     *
     * @param s
     * @return
     */
    static String longestPalindrome3(String s) {
        if (s == null) return s;
        char[] chars = s.toCharArray();
        if (chars.length <= 1) return s;
        int maxLength = 1;
        int begin = 0;
        int i = 0;
        while (i < chars.length) {
            int l = i - 1;
            int r = i;
            while (++r < chars.length && chars[r] == chars[i]) ;
            i = r;
            while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
                l--;
                r++;
            }
            int len = r - l - 1;
            if (len > maxLength) {
                maxLength = len;
                begin = l + 1;
            }
        }
        return new String(chars, begin, maxLength);
    }

    /**
     * @param cs
     * @param l
     * @param r
     * @return
     */
    private static int palindromeLength(char[] cs, int l, int r) {
        while (l >= 0 && r < cs.length && cs[l] == cs[r]) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcdefedcba"));
//        System.out.println(longestPalindrome2("abcdefedcba"));
//        System.out.println(longestPalindrome3("abcdefedcba"));
    }
}
