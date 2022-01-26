package com.arithmetic.cq.source.tenxun;

public class _53_最大子数组和 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int pre = 0;
        int maxAns = nums[0];
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public int maxSubArray1(int[] nums) {
        int pre = 0;
        int maxAns = nums[0];

        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            maxAns = Math.max(maxAns, pre);

        }
        return maxAns;
    }


    public static void main(String[] args) {
        _53_最大子数组和 o = new _53_最大子数组和();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        System.out.println(o.maxSubArray(nums));
        int[] nums1 = {5, 4, -1, 7, 8};
        System.out.println(o.maxSubArray(nums1));
    }
}
