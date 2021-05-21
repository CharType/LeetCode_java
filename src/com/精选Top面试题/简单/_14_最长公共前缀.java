package com.精选Top面试题.简单;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class _14_最长公共前缀 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int [] index = new int[strs.length];
        int subproffix = -1;
        boolean isSubproffix = false;
        do {
            subproffix++;
            isSubproffix = true;
            if (subproffix > strs[0].length() -1) {
                subproffix--;
                break;
            }
            char c = strs[0].charAt(subproffix);
            for (int i = 1; i < strs.length;i++) {
                String s = strs[i];
                if (subproffix > s.length()-1) {
                    subproffix--;
                    isSubproffix = false;
                    break;
                }
                if(s.charAt(subproffix) != c)  {
                    subproffix--;
                    isSubproffix = false;
                    break;
                }
            }

        } while (isSubproffix);

        return strs[0].substring(0,subproffix+1);
    }

    public static void main(String[] args) {
        _14_最长公共前缀 o = new _14_最长公共前缀();
//        String [] strs = {"c","c"};
        String [] strs = {"flower","flow","flowight"};
        System.out.println(o.longestCommonPrefix(strs));
    }
}
