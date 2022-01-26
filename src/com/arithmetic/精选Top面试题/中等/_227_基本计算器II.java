package com.arithmetic.精选Top面试题.中等;

/**
 *https://leetcode-cn.com/problems/basic-calculator-ii/
 */
public class _227_基本计算器II {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        char [] chars = s.toCharArray();
        if (chars.length == 1) {
            if (Character.isDigit(chars[0])) {
                return Integer.parseInt(s);
            } else {
                return 0;
            }
        }



        return 1;
    }



    public static void main(String[] args) {
        _227_基本计算器II o = new _227_基本计算器II();
        System.out.println(o.calculate("99"));
    }
}
