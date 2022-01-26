package com.arithmetic.精选Top面试题.简单;

/**
 *https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class _387_字符串中的第一个唯一字符 {

    public int firstUniqChar(String s) {
        int [] lastIndex = new int[128];
        char [] chas = s.toCharArray();

        for (int i = chas.length - 1;i >= 0;i--) {
            lastIndex[chas[i]] = lastIndex[chas[i]] + 1;
        }
        for (int i = 0;i <chas.length;i++) {
            if (lastIndex[chas[i]] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        _387_字符串中的第一个唯一字符 o =  new _387_字符串中的第一个唯一字符();
        System.out.println(o.firstUniqChar("eel"));
    }
}
