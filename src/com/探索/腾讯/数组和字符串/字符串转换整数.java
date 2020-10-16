package com.探索.腾讯.数组和字符串;

/**
 * https://leetcode-cn.com/explore/interview/card/tencent/221/array-and-strings/897/
 */
public class 字符串转换整数 {
    public int myAtoi(String str) {
        int len = str.length();
        char [] chars = str.toCharArray();
        // 去除字符串前面的空格
        int index = 0;
        while (index < len && chars[index] == ' ') {
            index++;
        }
        // 如果全部是空格直接返回0
        if (index == len) {
            return 0;
        }

        // 如果出现符号字符，仅第一个有效，并且记录正负
        int sign = 1;
        char firstChar = chars[index];
        if (firstChar == '+') {
            index++;
        } else if(firstChar == '-') {
            index++;
            sign = -1;
        }

        //后续出现的字符进行转换
        int res = 0;
        while (index < len) {
            char currChar = chars[index];
            if (currChar > '9' || currChar < '0') {
                break;
            }
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > (Integer.MAX_VALUE % 10))) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }


            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        字符串转换整数 o = new 字符串转换整数();
        String str = "-2147483647";
        int res = o.myAtoi(str);
        System.out.println(res);

//        System.out.println(Integer.MAX_VALUE);

    }
}
