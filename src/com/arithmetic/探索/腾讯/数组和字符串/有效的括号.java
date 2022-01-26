package com.arithmetic.探索.腾讯.数组和字符串;

import com.arithmetic.tools.Asserts;

import java.util.Stack;

/**
 * https://leetcode-cn.com/explore/interview/card/tencent/221/array-and-strings/901/
 */
public class 有效的括号 {
    public boolean isValid(String s) {
        if (s == null) return false;
        char [] chars = s.toCharArray();
        if (chars.length < 1) return true;
        if (chars.length == 1) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < chars.length;i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                stack.add(chars[i]);
            } else {
                if (stack.isEmpty()) return false;
                char leftchar = stack.pop();
                if ((chars[i] == ')' && leftchar != '(') ||
                        (chars[i] == ']' && leftchar != '[') ||
                        chars[i] == '}' && leftchar != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        有效的括号 o = new 有效的括号();
//        String s1 = "()";
//        Asserts.test(o.isValid(s1) == true);
//
//        String s2 = "()[]{}";
//        Asserts.test(o.isValid(s2) == true);
//
//
//        String s3 = "(]";
//        Asserts.test(o.isValid(s3) == false);
//
//        String s4 = "([)]";
//        Asserts.test(o.isValid(s4) == false);
//
//        String s5 = "{[]}";
//        Asserts.test(o.isValid(s5) == true);
//
//        String s6 = "((";
//        Asserts.test(o.isValid(s6) == true);

        String s7 = "}(";
        Asserts.test(o.isValid(s7) == false);

    }
}
