package com.arithmetic.other;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/number-of-good-pairs/
 */
public class _1512_好数对的数目 {

    /**
     * 暴力法
     * @param nums
     * @return
     */
    public int numIdenticalPairs(int[] nums) {
        if (nums == null || nums.length == 1) return 0;
        int count = 0;
        for (int i = 0;i < nums.length;i++) {
            for (int j = i+1;j < nums.length;j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public int numIdenticalPairs2(int[] nums) {
        if (nums == null || nums.length == 1) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (Integer num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        int count = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int v = entry.getValue();
            count += v * (v - 1) / 2;
        }
        return count;
    }

    public static void main(String[] args) {
        _1512_好数对的数目 o = new _1512_好数对的数目();
        int [] nums = {1,2,3,1,1,3};
        System.out.println(o.numIdenticalPairs2(nums));
    }
}
