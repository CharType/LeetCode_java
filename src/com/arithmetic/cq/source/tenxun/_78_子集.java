package com.arithmetic.cq.source.tenxun;

import java.util.ArrayList;
import java.util.List;

public class _78_子集 {

    public List<List<Integer>> subsets(int[] nums) {
        // 保存结果的数据
        List<List<Integer>> res = new ArrayList<>();
        // 先放一个空的数据
        res.add(new ArrayList<>());
        // 遍历每一个数字
        for (int i = 0; i < nums.length; i++) {
            int all = res.size();
            // 遍历集合数组，每个数组添加上当前的数字，然后再重新添加到集合中。
            for (int j = 0; j < all; j++) {
                List<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _78_子集 o = new _78_子集();
        int[] nums = {1, 2, 3};
        System.out.println(o.subsets(nums));
    }
}
