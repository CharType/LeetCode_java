package com.arithmetic.cq.source.tenxun;

import java.util.ArrayList;
import java.util.List;

public class _46_全排列 {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return null;
        dfs(new ArrayList<>(), nums, 0);
        return list;
    }


    public void dfs(List<Integer> array, int[] nums, int index) {
        if (index == nums.length) {
            list.add(new ArrayList(array));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (array.contains(nums[i])) continue;
            array.add(nums[i]);
            dfs(array, nums, index + 1);
            array.remove(array.size() - 1);
        }
    }

    public static void main(String[] args) {
        _46_全排列 o = new _46_全排列();
        int[] nums = {1, 2, 3};
        System.out.println(o.permute(nums));
    }
}
