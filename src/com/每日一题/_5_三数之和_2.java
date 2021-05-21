package com.每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *https://leetcode-cn.com/problems/3sum/
 * 解题思路
 * 1，先排好序
 * 2.
 */
public class _5_三数之和_2 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) return ans;
        int lastIndex = nums.length - 3;
        int lastR = nums.length - 1;
        for (int i = 0;i <= lastIndex;i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int l = i + 1;
            int r = lastR;
            int remian = -nums[i];
            while (l < r) {
                int sumLr = nums[l] + nums[r];
                if (sumLr == remian) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    ans.add(list);
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (sumLr < remian) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;

    }

    public List<List<Integer>> threeSum1(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;

        // 排序
        Arrays.sort(nums);

        // i用来扫描三元组的第一个元素
        int lastIdx = nums.length - 3;
        int lastR = nums.length - 1;
        for (int i = 0; i <= lastIdx; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = lastR, remain = -nums[i];
            while (l < r) {
                int sumLr = nums[l] + nums[r];
                if (sumLr == remain) { // 找到了符合条件的三元组
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 跳过相同的值（去重）
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    // 往中间逼近
                    l++;
                    r--;
                } else if (sumLr < remain) {
                    l++;
                } else { // sumLr > remain
                    r--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _5_三数之和_2 o = new _5_三数之和_2();
        int [] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(o.threeSum(nums));
//        System.out.printf("hahaha");
    }
}
