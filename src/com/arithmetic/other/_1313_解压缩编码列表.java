package com.arithmetic.other;

import com.arithmetic.tools.Integers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/decompress-run-length-encoded-list/
 */
public class _1313_解压缩编码列表 {
    public int[] decompressRLElist(int[] nums) {
        if (nums == null) return new int[0];
        int firstIndex = 0;
        int secondIndex = 1;
        List<Integer> list = new ArrayList<>();
        while (secondIndex < nums.length) {
            int num1 = nums[firstIndex];
            int num2 = nums[secondIndex];
            while (num1 > 0) {
                list.add(num2);
                num1--;
            }
            firstIndex += 2;
            secondIndex+= 2;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        _1313_解压缩编码列表 o = new _1313_解压缩编码列表();
        int [] nums = {1,3,4,2};
        Integers.println(o.decompressRLElist(nums));
    }
}
