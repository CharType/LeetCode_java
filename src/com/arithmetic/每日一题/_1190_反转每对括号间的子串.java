package com.arithmetic.每日一题;

import java.util.Stack;

/**
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * <p>
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * <p>
 * 注意，您的结果中 不应 包含任何括号。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * 示例 2：
 * <p>
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * 示例 3：
 * (ed(et(oc))el)
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * 示例 4：
 * <p>
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 2000
 * s 中只有小写英文字母和括号
 * 我们确保所有括号都是成对出现的
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1190_反转每对括号间的子串 {
    public String reverseParentheses(String s) {
        if (s == null || s.length() == 0) return "";
        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (chars[i] == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _1190_反转每对括号间的子串 o = new _1190_反转每对括号间的子串();
        System.out.println(o.reverseParentheses("(abcd)"));
        System.out.println(o.reverseParentheses("(u(love)i)"));
        System.out.println(o.reverseParentheses("(ed(et(oc))el)"));
        System.out.println(o.reverseParentheses("a(bcdefghijkl(mno)p)q"));
        return;
    }
}
