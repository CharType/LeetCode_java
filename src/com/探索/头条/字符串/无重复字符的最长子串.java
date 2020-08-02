package com.探索.头条.字符串;

import com.tools.Asserts;

public class 无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
       if (s == null || s.length() == 0) return 0;
       char [] chars = s.toCharArray();
       if (chars.length == 1) return 1;
       int [] prevIndexs = new int[128];
       for (int i = 0;i < prevIndexs.length;i++) {
           prevIndexs[i] = -1;
       }
       prevIndexs[chars[0]] = 0;
       int li = 0;
       int maxValue = 0;
       for (int i = 1;i < chars.length;i++) {
           int prev = prevIndexs[chars[i]];
           if (prev >= li) {
               li = prev + 1;
           }
           maxValue = Math.max(maxValue,i - li + 1);
           prevIndexs[chars[i]] = i;
       }
       return maxValue;
    }

    public static void main(String[] args) {
        无重复字符的最长子串 o = new 无重复字符的最长子串();
        Asserts.test(o.lengthOfLongestSubstring("df") == 2);
        Asserts.test(o.lengthOfLongestSubstring("abcabcbb") == 3);
        Asserts.test(o.lengthOfLongestSubstring("pwwkew") == 3);
        Asserts.test(o.lengthOfLongestSubstring("ckilbkd") == 5);
        Asserts.test(o.lengthOfLongestSubstring("dvdf") == 3);
        Asserts.test(o.lengthOfLongestSubstring("bpfbhmipx") == 7);

//        Asserts.test(o.lengthOfLongestSubstring1("abcabcbb") == 3);
//        Asserts.test(o.lengthOfLongestSubstring1("pwwkew") == 3);
//        Asserts.test(o.lengthOfLongestSubstring1("ckilbkd") == 5);
//        Asserts.test(o.lengthOfLongestSubstring1("dvdf") == 3);
//        Asserts.test(o.lengthOfLongestSubstring1("bpfbhmipx") == 7);
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) return 0;
        char [] chars = s.toCharArray();
        if (chars.length == 1) return 1;
        int [] prevIndex = new  int[128];
        for (int i = 0;i< prevIndex.length;i++) {
            prevIndex[i] = -1;
        }
        int maxValue = 1;
        prevIndex[chars[0]] = 0;
        int li = 0;
        for (int i = 1;i < chars.length;i++) {
            int prev =  prevIndex[chars[i]];
            if (prev >= li) {
                li = prev + 1;
            }
            maxValue = Math.max(maxValue,i - li + 1);
            prevIndex[chars[i]] = i;
        }
        return maxValue;

    }
}
