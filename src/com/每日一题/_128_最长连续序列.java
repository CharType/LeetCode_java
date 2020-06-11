package com.每日一题;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 */
public class _128_最长连续序列 {

    public int longestConsecutive(int[] nums) {
        if (nums == null) return 0;
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i = 0;i < nums.length;i++) {
            set.add(nums[i]);
        }
        int maxLength = 0;
        for (Integer num:set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currrentLen = 1;
                while (set.contains(currentNum+1)) {
                    currentNum++;
                    currrentLen++;
                }
                maxLength = Math.max(maxLength, currrentLen);
            }
        }

        return maxLength;

    }
    public int longestConsecutive1(int[] nums) {
        if (nums == null) return 0;
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        int maxLength = 0;
        for (int i = 0;i < nums.length;i++) {
            if (map.get(nums[i]) != null) continue;
            int leftLen = map.getOrDefault(nums[i] - 1,0);
            int rightLen = map.getOrDefault(nums[i] + 1,0);
            int currentLen = leftLen + rightLen + 1;
            map.put(nums[i], currentLen);
            map.put(nums[i]-leftLen, currentLen);
            map.put(nums[i]+rightLen, currentLen);
            maxLength = Math.max(maxLength,currentLen);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        _128_最长连续序列 o = new _128_最长连续序列();
        int [] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(o.longestConsecutive1(nums));
    }
}
