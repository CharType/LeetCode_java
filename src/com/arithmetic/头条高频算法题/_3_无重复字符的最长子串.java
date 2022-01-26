package com.arithmetic.头条高频算法题;

public class _3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        char [] chars = s.toCharArray();
        if (chars.length == 0) return 0;
        if (chars.length == 1) return 1;
        // 记录上次出现的所以
        int [] prevIndex = new int[128];
        for (int i = 0;i <prevIndex.length;i++) {
            prevIndex[i] = -1;
        }
        prevIndex[chars[0]] = 0;
        int li = 0;
        int maxValue = 1;
        for (int i = 1;i < chars.length;i++) {
            int pi = prevIndex[chars[i]];
            if (li <= pi) {
                li = pi + 1;
            }
            prevIndex[chars[i]] = i;
            maxValue = Math.max(maxValue,i - li +1);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        _3_无重复字符的最长子串 o = new _3_无重复字符的最长子串();
        System.out.println(o.lengthOfLongestSubstring("abcabcbb"));
    }
}
