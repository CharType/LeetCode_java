package com.探索.头条.字符串;

public class 翻转字符串里的单词 {
    public String reverseWords(String s) {
        if (s == null ) return "";
        char [] chars = s.toCharArray();
        // 记录一共有多少有效的元素
        int len = 0;
        // 记录当前可以插入的位置
        int cur = 0;
        // 记录前一个空格是否是空格字符
        Boolean space = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                chars[cur++] = chars[i];
                space = false;
            } else if (space == false) {
                chars[cur++] = chars[i];
                space = true;
            }
        }
        len = space ? (cur - 1) : cur;
        if (len <= 0) return "";
        revers(chars, 0, len);

        // 对每一个单词进行逆序
        // 记录前一个空格字符的位置
        int prevSapceIndex = -1;
        for (int i = 0; i < len; i++) {
            if (chars[i] != ' ') continue;
            revers(chars, prevSapceIndex + 1, i);
            prevSapceIndex = i;
        }
        revers(chars, prevSapceIndex + 1, len);

        return new String(chars,0,len);
    }

    // 将 l 和 r 范围内的 字符逆序 [)
    private void revers(char[] chars, int li, int ri) {
        ri--;
        while (li < ri) {
            char c = chars[li];
            chars[li] = chars[ri];
            chars[ri] = c;
            li++;
            ri--;
        }
    }

    public static void main(String[] args) {
        翻转字符串里的单词 o = new 翻转字符串里的单词();
//        System.out.printf(o.reverseWords("  how are you  "));
        System.out.printf(o.reverseWords("the sky is blue"));

    }
}
