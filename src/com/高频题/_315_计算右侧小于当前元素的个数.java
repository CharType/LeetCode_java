package com.高频题;

import com.sun.deploy.util.ArrayUtil;
import com.sun.tools.javac.util.ArrayUtils;
import com.tools.Integers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/
 *
 */
public class _315_计算右侧小于当前元素的个数 {

    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        int [] list = new int[nums.length];
        list[nums.length - 1] = 0;


        return Arrays.stream(list).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        _315_计算右侧小于当前元素的个数 o = new _315_计算右侧小于当前元素的个数();
        int [] nums = {5,2,6,1};
        System.out.println(o.countSmaller(nums));

    }
}
