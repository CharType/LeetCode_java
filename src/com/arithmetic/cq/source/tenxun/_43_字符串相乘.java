package com.arithmetic.cq.source.tenxun;

public class _43_字符串相乘 {
    public String multiply(String num1, String num2) {
        if (num1 == null && num2 == null) return "";
        if (num1 == null && num2 != null) return num2;
        if (num1 != null && num2 == null) return num1;
        if (num1.equals("0") || num2.equals("0")) return "0";
        char[] num1chars = num1.toCharArray();
        char[] num2chars = num2.toCharArray();
        if (num1chars.length == 0 && num2chars.length == 0) return "";
        int[] res = new int[num1chars.length + num2chars.length];
        for (int i = 0, lasti = num1chars.length - 1; i <= lasti; i++) {
            int n1 = num1chars[lasti - i] - '0';
            for (int j = 0, lastj = num2chars.length - 1; j <= lastj; j++) {
                int n2 = num2chars[lastj - j] - '0';
                int s = res[i + j] + n1 * n2;
                res[i + j] = s % 10;
                res[i + j + 1] += Math.floor(s / 10);
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean isZooe = false;
        for (int i = res.length - 1; i >= 0; i--) {
            if (res[i] != 0 || isZooe) {
                sb.append(res[i]);
                isZooe = true;
            }
        }
        return sb.toString();
    }

    public String multiply2(String num1, String num2) {
        if (num1 == null && num2 == null) return "";
        if (num1 == null && num2 != null) return num2;
        if (num1 != null && num2 == null) return num1;
        if (num1.equals("0") || num2.equals("0")) return "0";
        char[] num1chars = num1.toCharArray();
        char[] num2chars = num2.toCharArray();
        if (num1chars.length == 0 && num2chars.length == 0) return "";
        int[] res = new int[num1chars.length + num2chars.length];
        for (int i = 0, lasti = num1chars.length - 1; i <= lasti; i++) {
            int n1 = num1chars[lasti - i] - '0';
            for (int j = 0, lastj = num2chars.length - 1; j <= lastj; j++) {
                int n2 = num2chars[lastj - j] - '0';
                int s = res[i + j] + n1 * n2;
                res[i + j] = s % 10;
                res[i + j + 1] += Math.floor(s / 10);
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean isZooe = false;
        for (int i = res.length - 1; i >= 0; i--) {
            if (res[i] != 0 || isZooe) {
                sb.append(res[i]);
                isZooe = true;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _43_字符串相乘 o = new _43_字符串相乘();
        String s1 = "123";
        String s2 = "456";
        System.out.println(o.multiply(s1, s2));
    }
}
