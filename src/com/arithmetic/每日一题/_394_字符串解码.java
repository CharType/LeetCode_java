package com.arithmetic.每日一题;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/decode-string/
 */
public class _394_字符串解码 {

        int ptr;

        public String decodeString(String s) {
            LinkedList<String> stk = new LinkedList<String>();
            ptr = 0;

            while (ptr < s.length()) {
                char cur = s.charAt(ptr);
                if (Character.isDigit(cur)) {
                    // 获取一个数字并进栈
                    String digits = getDigits(s);
                    stk.addLast(digits);
                } else if (Character.isLetter(cur) || cur == '[') {
                    // 获取一个字母并进栈
                    stk.addLast(String.valueOf(s.charAt(ptr++)));
                } else {
                    ++ptr;
                    LinkedList<String> sub = new LinkedList<String>();
                    while (!"[".equals(stk.peekLast())) {
                        sub.addLast(stk.removeLast());
                    }
                    Collections.reverse(sub);
                    // 左括号出栈
                    stk.removeLast();
                    // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                    int repTime = Integer.parseInt(stk.removeLast());
                    StringBuffer t = new StringBuffer();
                    String o = getString(sub);
                    // 构造字符串
                    while (repTime-- > 0) {
                        t.append(o);
                    }
                    // 将构造好的字符串入栈
                    stk.addLast(t.toString());
                }
            }

            return getString(stk);
        }

        public String getDigits(String s) {
            StringBuffer ret = new StringBuffer();
            while (Character.isDigit(s.charAt(ptr))) {
                ret.append(s.charAt(ptr++));
            }
            return ret.toString();
        }

        public String getString(LinkedList<String> v) {
            StringBuffer ret = new StringBuffer();
            for (String s : v) {
                ret.append(s);
            }
            return ret.toString();
        }

    public String decodeString1(String s) {
        if (s == null || s.length() == 0) return s;
        // 1, 将字符串转换为字符数组
        char [] strs = s.toCharArray();
        // 2遍历字符串一直入栈 知道遇到]
        Stack<Character> stack = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length ;i++) {
            char c = strs[i];
            if (c == ']') {
                StringBuilder tempsb = new StringBuilder();
                while (stack.peek() != '[') {
                    char y =stack.peek();
                    tempsb.insert(0,y);
                    stack.pop();
                }
                // pop掉 [ 左边框
                stack.pop();
                int num = 0;
                int x = 1;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                   num = num + x * Integer.parseInt(String.valueOf(stack.pop()));
                   x *= 10;
                }
                if (!stack.isEmpty() && !Character.isDigit(stack.peek())) {
                    for (int j = 0; j < num;j++) {
                        char [] tempchars = tempsb.toString().toCharArray();
                        for (char cs : tempchars) {
                            stack.add(cs);
                        }
                    }
                    continue;
                } else {
                    for (int j = 0; j < num;j++) {
                        sb.append(tempsb);
                    }
                }
            } else {
                stack.add(c);
            }
        }
        if (!stack.isEmpty()) {
            StringBuilder tempsb = new StringBuilder();
            while (!stack.isEmpty()) {
                tempsb.insert(0,stack.pop());
            }
            sb.append(tempsb);
        }
        // 使用可变字符串拼接
        return sb.toString();
    }

    public static void main(String[] args) {
        _394_字符串解码 o = new _394_字符串解码();
//        System.out.println(o.decodeString("3[a]2[bc]"));
//        System.out.println(o.decodeString("3[a2[c]]"));
//        System.out.println(o.decodeString("2[abc]3[cd]ef"));
        System.out.println(o.decodeString("100[leetcode]"));

    }
}
