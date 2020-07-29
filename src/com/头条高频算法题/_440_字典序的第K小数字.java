package com.头条高频算法题;

/**
 * https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/
 */
public class _440_字典序的第K小数字 {
    public int findKthNumber(int n, int k) {
        int prefix = 1;
        int count = 1;
        while (count < k) {
            int curCount = count(prefix,n);
            if (curCount + count > k) {
                prefix *= 10;
                count++;
            } else {
                prefix++;
                count += curCount;
            }
        }
        return prefix;
    }

    private int count(int prefix, int n) {
        long nextPrefix = prefix + 1;
        int count = 0;
        while (prefix < n) {
            count += Math.min(n + 1, nextPrefix) - prefix;
            prefix *= 10;
            nextPrefix *= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        _440_字典序的第K小数字 o = new _440_字典序的第K小数字();
        System.out.println(o.findKthNumber(13,2));
    }
}
