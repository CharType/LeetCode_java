package com.arithmetic.other;

/**
 * https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 */
public class _1342_将数字变成0的操作次数 {
    public int numberOfSteps (int num) {
        if (num == 0) return 0;
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 0) {
                num = num / 2;
            } else {
                num -= 1;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        _1342_将数字变成0的操作次数 o = new _1342_将数字变成0的操作次数();
        System.out.println(o.numberOfSteps(14));
    }
}
