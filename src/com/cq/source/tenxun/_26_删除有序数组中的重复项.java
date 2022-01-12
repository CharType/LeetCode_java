package com.cq.source.tenxun;


public class _26_删除有序数组中的重复项 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        _26_删除有序数组中的重复项 o = new _26_删除有序数组中的重复项();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(o.removeDuplicates(nums));
    }
}
