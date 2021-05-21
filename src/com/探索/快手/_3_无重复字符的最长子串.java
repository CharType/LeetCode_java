package com.探索.快手;

public class _3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        char [] chars = s.toCharArray();
        if (chars.length <= 1) return chars.length;
        int [] prevIndexs = new int[128];
        for (int i = 0;i < prevIndexs.length;i++) {
            prevIndexs[i] = -1;
        }

        prevIndexs[chars[0]] = 0;
        int li = 0;
        int len = 0;
        for (int i = 1;i < chars.length;i++) {
            int prevIndex = prevIndexs[chars[i]];
            if (prevIndex >= li) {
                li = prevIndex + 1;
            }
            len = Math.max(len,i - li + 1);
            prevIndexs[chars[i]] = i;
        }

        return len;
    }

    public static void main(String[] args) {
        _3_无重复字符的最长子串 o = new _3_无重复字符的最长子串();
//        System.out.println(o.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(o.lengthOfLongestSubstring("acb"));
    }
}
