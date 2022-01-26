package com.arithmetic.精选Top面试题.中等;

import com.arithmetic.tools.Asserts;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 */
public class _3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
       if (s == null) return 0;
       char [] chars = s.toCharArray();
       if (chars.length == 0) return 0;
       if (chars.length == 1) return 1;
       int li = 0;
       int maxValue = 1;
       Map<Character,Integer> prevIndex = new HashMap<>();
       prevIndex.put(chars[0],0);
       for (int i = 1;i < chars.length;i++) {
           int prev = prevIndex.getOrDefault(chars[i],-1);
           if (prev >= li) {
               li = prev + 1;
           }
           maxValue = Math.max(maxValue,i - li + 1);
           prevIndex.put(chars[i],i);
       }
       return maxValue;
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s == null) return 0;
        char [] chars = s.toCharArray();
        if (chars.length == 0) return 0;
        if (chars.length == 1) return 1;
        int [] prevIndex = new int[128];
        for (int i = 0;i < prevIndex.length;i++) {
            prevIndex[i] = -1;
        }
        prevIndex[chars[0]] = 0;
        int li = 0;
        int maxValue = 1;
        for (int i = 1;i < chars.length;i++) {
            int prev = prevIndex[chars[i]];
            if (prev >= li) {
                li = prev + 1;
            }
            maxValue = Math.max(maxValue,i - li + 1);
            prevIndex[chars[i]] = i;
        }
        return maxValue;
    }

    public static void main(String[] args) {
        _3_无重复字符的最长子串 o = new _3_无重复字符的最长子串();
        Asserts.test(o.lengthOfLongestSubstring1("abcabcbb") == 3);
        Asserts.test(o.lengthOfLongestSubstring1("pwwkew") == 3);
        Asserts.test(o.lengthOfLongestSubstring1("ckilbkd") == 5);
        Asserts.test(o.lengthOfLongestSubstring1("dvdf") == 3);
        Asserts.test(o.lengthOfLongestSubstring1("bpfbhmipx") == 7);
//         //bpfbhmipx
//        // 123345656
//
    }
}
