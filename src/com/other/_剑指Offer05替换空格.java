package com.other;

/**
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class _剑指Offer05替换空格 {
    public String replaceSpace(String s) {
        if (s == null) return null;
        char [] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < chars.length;i++) {
            if (chars[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _剑指Offer05替换空格 o = new _剑指Offer05替换空格();
        System.out.println(o.replaceSpace("we are ok!"));
    }
}
