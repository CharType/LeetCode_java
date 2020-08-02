package com.探索.头条.字符串;

/**
 * https://leetcode-cn.com/problems/multiply-strings/
 * 转换成字符数组  然后尾部相乘
 */
public class _43_字符串相乘 {

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) return "";
        char [] nchar1 = num1.toCharArray();
        char [] nchar2 = num2.toCharArray();
        if (nchar1.length == 0 || nchar2.length == 0) return "";
        if (num1.equals("0") || num2.equals("0")) return "0";
        // 声明一个数组用来存储数据，num1 * num2 的位数不会大于2数位数的和,
        // 所以数组元素的个数最多为num1的个数加num2元素的个数

        int [] list = new int[nchar1.length + nchar2.length];
        for (int i = 0,last1 = nchar1.length - 1;i <= last1;i++) {
            Integer n1 = Integer.parseInt(String.valueOf(nchar1[last1 - i]));
            for (int j = 0,last2 = nchar2.length - 1;j <= last2;j++) {
                Integer n2 = Integer.parseInt(String.valueOf(nchar2[last2 - j]));
                // 当前位计算等于之前计算上的结果+ 本次计算的结果
                int s = list[i + j] + n1 * n2;
                // 当前位存 %10 之后的结果
                list[i + j] = s % 10;
                // 后一位存它自己+当前位除10 之后的进位
                list[i + j + 1] += Math.floor(s / 10);
            }
        }

        // 反序拼接字符串
        StringBuilder sb = new StringBuilder();
        boolean isappend = false;
        for (int i = list.length-1;i >= 0;i--) {
            if (list[i] != 0 || isappend) {
                sb.append(list[i]);
                isappend = true;
            }
        }

        return sb.toString();
    }

    public String multiply3(String num1,String num2) {
        if (num1 == null || num2 == null) return "";
        if (num1.equals("0") || num2.equals("0")) return "0";
        char [] n1chars = num1.toCharArray();
        char [] n2chars = num2.toCharArray();
        if (n1chars.length == 0 || n2chars.length == 0) return "";
        int [] result = new int[n1chars.length + n2chars.length];
        int n1length = n1chars.length - 1;
        int n2length = n2chars.length - 1;
        for(int i = 0; i <=n1length;i++) {
            int n1 = Integer.parseInt(String.valueOf(n1chars[n1length-i]));
            for(int j = 0;j<=n2length;j++) {
                int n2 = Integer.parseInt(String.valueOf(n2chars[n2length-j]));
                int sum = result[i + j] + n1 * n2;
                result[i + j] = sum % 10;
                result[i + j + 1] += Math.floor(sum / 10);
            }
        }

        StringBuffer sb = new StringBuffer();
        boolean isappend = false;
        for(int i = result.length-1;i>=0;i--) {
            if(result[i] != 0 || isappend) {
                isappend = true;
                sb.append(result[i]);
            }
        }
        return sb.toString();
    }

    public String multiply2(String num1, String num2) {
        if (num1 == null || num2 == null) return num1;
        if (num1.equals("0") || num2.equals("0")) return "0";
        char [] char1s = num1.toCharArray();
        char [] char2s = num2.toCharArray();
        if (char1s.length == 0 || char2s.length == 0) return "";
        int [] results = new int[char1s.length + char2s.length];
        for (int i = 0,lasti = char1s.length - 1;i <= lasti;i++) {
            int n1 = Integer.parseInt(String.valueOf(char1s[lasti - i]));
            for (int j = 0,lastj = char2s.length - 1;j <= lastj;j++) {
                int n2 = Integer.parseInt(String.valueOf(char2s[lastj - j]));
                int s = results[i + j] + n1 * n2;
                results[i + j] = s % 10;
                results[i + j + 1] += Math.floor(s / 10);
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean isZooe = false;
        for (int i = results.length-1;i >= 0;i--) {
            if (results[i] != 0 || isZooe) {
                sb.append(results[i]);
                isZooe = true;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _43_字符串相乘 o = new _43_字符串相乘();
        String s1 = "123";
        String s2 = "456";
        System.out.println(o.multiply3(s1,s2));
    }
}
