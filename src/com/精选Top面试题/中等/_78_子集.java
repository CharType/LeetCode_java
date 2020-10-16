package com.精选Top面试题.中等;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 */
public class _78_子集 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for (int i = 0;i < nums.length;i++) {
            int all = list.size();
            for (int j = 0;j < all;j++) {
                ArrayList temp = new ArrayList(list.get(j));
                temp.add(nums[i]);
                list.add(temp);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        _78_子集 o = new _78_子集();
        int [] nums = {1,2,3,4};
        System.out.println(o.subsets(nums));
    }
}
