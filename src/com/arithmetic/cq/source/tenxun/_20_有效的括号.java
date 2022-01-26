package com.arithmetic.cq.source.tenxun;

import java.util.Stack;

public class _20_有效的括号 {
    public boolean isValid(String s) {
        if (s == null) return false;
        char[] chars = s.toCharArray();
        if ((chars.length & 1) == 1) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char curr = chars[i];
            if (curr == '(' || curr == '[' || curr == '{') {
                stack.push(curr);
                continue;
            }
            if (!stack.isEmpty() && ((curr == ')' && stack.peek() == '(') ||
                    (curr == ']' && stack.peek() == '[') ||
                    (curr == '}' && stack.peek() == '{'))) {
                stack.pop();
            } else {
                return false;
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        _20_有效的括号 o = new _20_有效的括号();
//        System.out.print(o.isValid("{}()()[]"));
        System.out.print(o.isValid("])"));
    }
}
