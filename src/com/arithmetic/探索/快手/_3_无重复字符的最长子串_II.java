package com.arithmetic.探索.快手;

public class _3_无重复字符的最长子串_II {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        char [] chars = s.toCharArray();
        if (s.length() <= 1) return s.length();
        int [] prevIndexs = new int[128];
        for (int i = 0;i < prevIndexs.length;i++) {
            prevIndexs[i] = -1;
        }
        prevIndexs[chars[0]] = 0;
        int maxLen = 1;
        int li = 0;
        for (int i =1;i<chars.length;i++) {
            int prevIndex = prevIndexs[chars[i]];
            if (prevIndex >= li) {
                li = prevIndex + 1;
            }
            int len = i - li + 1;
            maxLen = Math.max(len,maxLen);
            prevIndexs[chars[i]] = i;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        _3_无重复字符的最长子串_II o = new _3_无重复字符的最长子串_II();
        System.out.println(o.lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(o.lengthOfLongestSubstring("acb"));
    }
}
