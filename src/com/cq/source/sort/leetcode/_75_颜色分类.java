package com.cq.source.sort.leetcode;

import com.tools.Integers;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 */
public class _75_颜色分类 {
    public void sortColors(int[] nums) {
        int i = 0;
        int l = 0;
        int r = nums.length - 1;
        while (i <= r) {
            if (nums[i] == 0) {
                swap(nums, l, i);
                l++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, r, i);
                r--;
            } else {
                i++;
            }
        }
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        _75_颜色分类 o = new _75_颜色分类();
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        o.sortColors(nums1);
        Integers.println(nums1);
    }
}
