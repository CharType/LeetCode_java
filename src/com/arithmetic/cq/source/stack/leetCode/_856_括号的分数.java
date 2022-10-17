package com.arithmetic.cq.source.stack.leetCode;

import com.arithmetic.cq.source.stack.Stack;

/**
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 * <p>
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/score-of-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _856_括号的分数 {
    public int scoreOfParentheses(String s) {
        if (s == null && s.length() <= 2) return 0;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(chars[i]);
            } else if (chars[i] == ')') {
                if (stack.peek() == '(') {
                    sum += 1;
                    stack.pop();
                } else {

                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
