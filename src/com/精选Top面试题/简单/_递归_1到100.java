package com.精选Top面试题.简单;

/**
 * 递归从1加到100
 */
public class _递归_1到100 {
    public static  int sum(int number) {
        if (number == 1) return 1;
        return sum(number-1) + number;
    }
    public static void main(String[] args) {
        System.out.print(sum(100));
    }
}
