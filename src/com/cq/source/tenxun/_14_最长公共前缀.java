package com.cq.source.tenxun;

public class _14_最长公共前缀 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int index = 0;
        int li = 0;
        // 找到最小的
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLength = Math.min(strs[i].length(), minLength);
        }
        // 可以使用二分查找优化
        for (int i = 0; i < minLength; i++) {
            char currChar = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                String currString = strs[j];
                if (currString.charAt(i) != currChar) {
                    return new String(strs[0].toCharArray(), li, index);
                }

            }
            index++;
        }
        return new String(strs[0].toCharArray(), li, index);
    }

    public static void main(String[] args) {
        _14_最长公共前缀 o = new _14_最长公共前缀();
        String[] strs = {"flower", "flow", "flowight"};
        System.out.println(o.longestCommonPrefix(strs));
    }
}
