package com.头条高频算法题;

import java.util.ArrayList;
import java.util.List;

/**
 *https://leetcode-cn.com/problems/permutations/
 */
public class _46_全排列 {
    private List<List<Integer>> list;
    private int [] nums;
    // 用来保存每一层的数据
    private List<Integer> result;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return null;
        list = new ArrayList<>();
        if (nums.length == 0) return list;
        this.nums = nums;
        result = new ArrayList<>();
        dfs(0);
        return list;
    }

    private void dfs(int index) {
        if (index == nums.length) {
            list.add(new ArrayList<>(result));
            return;
        }
        for (int num : nums) {
            if (result.contains(num)) continue;
            result.add(num);
            dfs(index + 1);
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {
        _46_全排列 o = new _46_全排列();
        int [] nums = {1,2,3};
        System.out.println(o.permute(nums));
    }
}
