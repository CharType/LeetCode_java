package com.探索.头条.字符串;

/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1014/
 * 1.先找到最端的字符串长度
 * 2.定义2个指针 从最左和最右往中间进行而二分查找
 * (hig - low + 1) / 2 + low;
 * 每次计算当前的串数组中是不是公共的前缀，不是leef
 */
public class 最长公共前缀 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        // 先找到最短的字符串的长度
        int minLength = Integer.MAX_VALUE;
        for (int i = 0;i<strs.length;i++) {
            minLength = Math.min(minLength, strs[i].length());
        }
        int low = 0,hig= minLength;
        while (low < hig) {
           int mid = (hig - low + 1) / 2 + low;
           if (isCommonPrefix(strs,mid)) {
               low = mid;
           } else {
               hig = mid - 1;
           }
        }

        return strs[0].substring(0, low);
    }

    public  boolean isCommonPrefix(String [] strs,int length) {
        String str0 = strs[0].substring(0,length);
        for (int i = 1; i < strs.length;i++) {
            String str = strs[i];
            for (int j = 0;j < length;j++) {
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        最长公共前缀 o = new 最长公共前缀();
        String [] strs = {"flower","flow","flowight"};
        System.out.println(o.longestCommonPrefix(strs));
    }
}
