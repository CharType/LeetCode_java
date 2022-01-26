package com.arithmetic.精选Top面试题.简单;

/**
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 *
 */
public class _实现_strStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        char [] hays = haystack.toCharArray();
        char [] needles = needle.toCharArray();
        if (needles.length > hays.length) return -1;
        if (needles.length == 0 && needles.length == 0) return 0;
        for (int i = 0;i<hays.length;i++) {
            if (hays[i] == needles[0]) {
                if (i + needles.length > hays.length) return -1;
                int hayIndex = i;
                int needIndex = 0;
                boolean isbrreak = false;
                while (hayIndex < hays.length && needIndex < needles.length) {
                    if (hays[hayIndex] != needles[needIndex]){
                        isbrreak = true;
                        break;
                    }
                    hayIndex++;
                    needIndex++;
                }
                if (!isbrreak) {
                    return i;
                } else {
                   i = i+needIndex ;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        _实现_strStr o = new _实现_strStr();
        System.out.println(o.strStr("mississippi","issip"));
    }
}
