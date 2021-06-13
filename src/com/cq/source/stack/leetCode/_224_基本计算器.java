package com.cq.source.stack.leetCode;

import com.cq.source.stack.Stack;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 示例 1：
 * <p>
 * 输入：s = "1 + 1"
 * 输出：2
 */
public class _224_基本计算器 {

    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Object> stack = new Stack<>();
        int sum = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '+') {
                int c = (int) stack.pop();
                stack.push(c + chars[i]);
            } else if (chars[i] == '-') {
                int c = (int) stack.pop();
                stack.push(c - chars[i]);
            } else {
                stack.push(chars[i]);
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
