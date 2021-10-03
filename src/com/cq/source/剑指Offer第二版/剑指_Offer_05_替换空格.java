package com.cq.source.剑指Offer第二版;

public class 剑指_Offer_05_替换空格 {

    public String replaceSpace(String s) {
        if (s == null) return null;
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
