package com.arithmetic.探索.腾讯.数组和字符串;

/**
 * https://leetcode-cn.com/leetbook/read/tencent/xxbolr/
 */
public class 字符串相乘 {

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) return null;
        if (num1.equals("0") || num2.equals("0")) return "0";
        char [] num1s = num1.toCharArray();
        char [] num2s = num2.toCharArray();
        // 保存所有的数据长度为m+n
        int [] result = new int[num1s.length + num2s.length];
        // 第一个数组遍历
        for (int i = 0, lasti = num1s.length-1;i <= lasti ;i++) {
            // 取到第一个数组，lasti - i 取到的是数组尾部的数字
            int n1 = Integer.parseInt(String.valueOf(num1s[lasti - i]));
            for (int j = 0,lastj = num2s.length-1;j <=lastj;j++) {
                // 取到第二个数字lastj - j也是取到到是尾部数字
                int n2 = Integer.parseInt(String.valueOf(num2s[lastj - j]));
                // 计算呢出所有的和 当前数字计算之前是之前的进位值
                int sum = n1 * n2 + result[i + j];
                // 计算出当前数值要存的值
                result[i + j] = sum % 10;
                // 保存进位的值
                result[i+ j + 1] += Math.floor(sum / 10);
            }
        }
        boolean isappendZeor = false;
        StringBuilder sb = new StringBuilder();
        for (int i = result.length-1;i >= 0;i--) {
            if (result[i] != 0 || isappendZeor) {
                sb.append(result[i]);
                isappendZeor = true;
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        字符串相乘 o = new 字符串相乘();
        System.out.println(o.multiply("123","456"));
    }
}
