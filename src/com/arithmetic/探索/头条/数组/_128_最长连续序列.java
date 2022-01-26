package com.arithmetic.探索.头条.数组;


import com.arithmetic.tools.Times;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 */
public class _128_最长连续序列 {

    public int longestConsecutive1(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }


    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (Integer num : nums) {
            set.add(num);
        }
        int maxValue = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int sum = 1;
                while (set.contains(num + 1)){
                    sum += 1;
                    num++;
                }
                maxValue = Math.max(sum,maxValue);
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        _128_最长连续序列 o = new _128_最长连续序列();
        int [] nums = {100, 4, 200, 1, 3, 2};
//        int [] nums = {0,0,-1};
        Times.test("自己的解法", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(o.longestConsecutive(nums));
            }
        });

        Times.test("官方的解法", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(o.longestConsecutive1(nums));
            }
        });
    }
}
