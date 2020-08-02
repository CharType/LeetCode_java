package com.other;

public class 剑指Offer58II左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
        if (s == null) return null;
        char [] chars = s.toCharArray();
        if (chars.length <= 1) return s;
        int index = n % chars.length;
        char [] tempChar = new char[index];
        for (int i = 0;i < index;i++) {
            tempChar[i] = chars[i];
        }
        int currentIndex = 0;
        int tempInsertIndex = index;
        while (tempInsertIndex < chars.length) {
            chars[currentIndex] = chars[tempInsertIndex];
            currentIndex++;
            tempInsertIndex++;
        }
        for (int i =currentIndex;i < chars.length;i++ ) {
            chars[i] = tempChar[i - currentIndex];
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        剑指Offer58II左旋转字符串 o  = new 剑指Offer58II左旋转字符串();
        System.out.println(o.reverseLeftWords("abcdefgh",2));
    }
}
