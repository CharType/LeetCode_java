package com.探索.快手;

import java.util.HashSet;
import java.util.Set;

/**
 *https://leetcode-cn.com/problems/happy-number/
 */
public class _202_快乐数 {
    public boolean isHappy(int n) {
        if (n == 1) return true;
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int num = n;
            int sum = 0;
            while (num >= 1) {
                int m = num % 10;
                sum += (m * m);
                num = num / 10;
            }
            if (set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
                n = sum;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _202_快乐数 o = new _202_快乐数();
        System.out.println(o.isHappy(19));
    }
}
