package com.每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
 * 未做出
 */
public class _974_和可被K整除的子数组 {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem: A) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        _974_和可被K整除的子数组 o = new _974_和可被K整除的子数组();
        int [] nums = {4,5,0,-2,-3,1};
        System.out.println(o.subarraysDivByK(nums,5));

//        System.out.println(11 % 5);
//        System.out.println((11 % 5 + 5) % 5);
    }
}
