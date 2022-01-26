package com.arithmetic.探索.快手;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class _47_全排列II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        int len  = nums.length;
        // 必须排序，不管是升序还是降序
        Arrays.sort(nums);
        // 用来记录当前的数字是否已经加入到排列中
        boolean [] used = new boolean[len];
        // 记录排列的数据
        Deque<Integer> path = new ArrayDeque<>(len);
        // 搜索
        dfs(nums,len,0,used,path,result);
        return result;
    }


    /**
     *
     * @param nums  数组
     * @param length  数组长度
     * @param depth   数组深度
     * @param used    记录是否有加入
     * @param path   存储本次排列的容器
     * @param res   最终的返回值
     */
    public void dfs(int [] nums,Integer length,Integer depth,boolean [] used,Deque<Integer> path,List<List<Integer>> res) {
        if (depth == length) {
            // 如果深度和length相等了 就直接添加
            res.add(new ArrayList<>(path));
            return;
        }
        // 遍历
        for (int i = 0;i < length;i++) {
            // 如果已经添加就跳过
            if (used[i]) continue;
            // 如果当前值和上一个的值相等 并且上一个数据是没有存储过的，就跳过 否则就继续
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            // 将当前数据添加带队列尾部
            path.addLast(nums[i]);
            // 设置当前数据已经存储
            used[i] = true;
            // 递归调用，深度+1
            dfs(nums,length,depth + 1,used,path,res);
            // 设置当前数据没有存储
            used[i] = false;
            // 删除当前数据
            path.removeLast();
        }
    }



    public static void main(String[] args) {
        _47_全排列II o = new _47_全排列II();
        int [] nums = {1,1,1,1,1,2};
        System.out.println(o.permuteUnique(nums));
    }
}
