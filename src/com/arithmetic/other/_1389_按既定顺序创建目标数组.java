package com.arithmetic.other;

import com.arithmetic.tools.Integers;

import java.util.ArrayList;
import java.util.List;

public class _1389_按既定顺序创建目标数组 {
    public int[] createTargetArray(int[] nums, int[] index) {
        if (nums == null || index == null) return null;
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < index.length;i++) {
            list.add(index[i],nums[i]);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
    public static void main(String[] args) {
        _1389_按既定顺序创建目标数组 o = new _1389_按既定顺序创建目标数组();
        int [] nums = {0,1,2,3,4};
        int [] index = {0,1,2,2,1};
        Integers.println(o.createTargetArray(nums,index));
    }
}
