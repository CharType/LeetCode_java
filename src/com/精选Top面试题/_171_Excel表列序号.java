package com.精选Top面试题;

/**
 * https://leetcode-cn.com/problems/excel-sheet-column-number/
 */
public class _171_Excel表列序号 {
    public int titleToNumber(String s) {
        if (s == null) return 0;
        char [] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            res = res * 26 + chars[i] - 'A' + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        _171_Excel表列序号 o = new _171_Excel表列序号();
        System.out.println(o.titleToNumber("ZYS"));
    }
}
