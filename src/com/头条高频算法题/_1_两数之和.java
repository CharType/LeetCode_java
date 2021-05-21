package com.头条高频算法题;


import com.tools.Integers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 */
public class _1_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[0];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i< nums.length; i++) {
            int number = target - nums[i];
            Integer temp = map.get(number);
            if (temp != null) {
                int [] n = {temp,i};
                return n;

            } else {
                map.put(nums[i],i);
            }
        }
        return new int[0];
    }

    public List<List<Integer>> twoSum2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i< nums.length; i++) {
            int number = target - nums[i];
            Integer temp = map.get(number);
            if (temp != null) {
                List<Integer> array = new ArrayList<>();
                array.add(temp);
                array.add(i);
                list.add(array);
            } else {
                map.put(nums[i],i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        _1_两数之和 o = new _1_两数之和();
        int [] nums = {2, 7, 11, 15,3,6};
        Integers.println(o.twoSum(nums,9));
        List<List<Integer>> array = o.twoSum2(nums,9);
        for (int i = 0;i < array.size();i++) {
            List<Integer> list = array.get(i);
            System.out.println(list.toString());

        }
    }
}
