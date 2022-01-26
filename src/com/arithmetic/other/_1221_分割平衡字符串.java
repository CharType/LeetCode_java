package com.arithmetic.other;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 */
public class _1221_分割平衡字符串 {
    public int balancedStringSplit(String s) {
        if (s == null) return 0;
        char [] chars = s.toCharArray();
        if (chars.length == 0) return 0;
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0;i < chars.length;i++) {
            if(stack.isEmpty() || stack.peek() == chars[i]) {
                stack.add(chars[i]);
            } else if((chars[i] == 'R' && stack.peek() == 'L') || (chars[i] == 'L' && stack.peek() == 'R')) {
                while (!stack.isEmpty()) {
                    stack.pop();
                    i++;
                }
                count++;
            } else {
                stack.add(chars[i]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        _1221_分割平衡字符串 o = new _1221_分割平衡字符串();
        System.out.println(o.balancedStringSplit("RLRRLLRLRL"));
//        System.out.println(o.balancedStringSplit("RLLLLRRRLR"));
//        System.out.println(o.balancedStringSplit("LLLLRRRR"));
    }
}
