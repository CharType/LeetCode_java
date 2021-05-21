package com.探索.快手;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 */
public class _46_全排列 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return null;
        dfs(nums,0,new ArrayList<Integer>());
        return result;
    }

    public void dfs(int [] nums,Integer index,List<Integer> list) {
        if (index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0;i < nums.length;i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            dfs(nums,index+1,list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        _46_全排列 o = new _46_全排列();
        int [] nums = {1,2,3};
        System.out.println(o.permute(nums));
    }
}
