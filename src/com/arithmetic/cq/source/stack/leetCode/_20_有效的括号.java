package com.arithmetic.cq.source.stack.leetCode;

import com.arithmetic.cq.source.stack.Stack;

public class _20_有效的括号 {
    public boolean isValid(String s) {
        if (s == null || s.length() <= 1) return false;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                stack.push(chars[i]);
            } else {
                if (!stack.isEmpty() && ((chars[i] == ')' && stack.peek() == '(') ||
                        chars[i] == ']' && stack.peek() == '[' ||
                        chars[i] == '}' && stack.peek() == '{')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        _20_有效的括号 o = new _20_有效的括号();
        System.out.print(o.isValid("{}()()[]"));
    }
}
