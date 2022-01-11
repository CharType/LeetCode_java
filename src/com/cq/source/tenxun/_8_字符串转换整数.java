package com.cq.source.tenxun;

public class _8_字符串转换整数 {
    public int myAtoi(String s) {
        if (s == null) return 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
        // 去掉前面的空格
        int index = 0;
        while (index < len && chars[index] == ' ') {
            index++;
        }

        // 全部是空格的情况
        if (index == len) return 0;

        // 判断第一个字符是否是符号位
        int singn = 1;
        char firstChar = chars[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            singn = -1;
        }

        int res = 0;
        while (index < len) {
            char currChar = chars[index];
            // 遇到不是数字的直接退出
            if (currChar > '9' || currChar < '0') {
                break;
            }
            // 检验是否溢出和其他字符-'0' 的问题
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > (Integer.MAX_VALUE % 10))) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            res = res * 10 + singn * (currChar - '0');
            index++;
        }

        return res;
    }

    public static void main(String[] args) {
        _8_字符串转换整数 o = new _8_字符串转换整数();
//        System.out.println(o.myAtoi("87978kajhdska"));
//        System.out.println(o.myAtoi("21474836460"));
        System.out.println(o.myAtoi("-2147483647"));
    }

}
