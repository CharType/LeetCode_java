package com.精选Top面试题.简单;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 *
 * 如果 n 是快乐数就返回 True ；不是，则返回 False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _202_快乐数 {
    public boolean isHappy(int n) {
        if (n <= 0)return false;
        if (n == 1)return true;
        List<Integer> list = new ArrayList<Integer>();
        list.add(n);
        int value = n;

        while (value != 1) {
            int sum = 0;
            while (value > 0) {
                int temp = value % 10;
                sum += temp * temp;
                value = value / 10;
            }
            if (list.contains(sum)) {
                return false;
            } else {
                list.add(sum);
            }
            if (sum == 1) return true;
            value = sum;
        }
        return false;
    }

    public static void main(String[] args) {
        _202_快乐数 o = new _202_快乐数();
        System.out.println(o.isHappy(2));
    }
}
