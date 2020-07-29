package com.头条高频算法题;

public class _33_搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return nums[0] == target ? 0 : -1;
        int l = 0,r = n - 1;
        while (l <= r) {
            int mid = (l + r)/2;
            if (nums[mid] == target) return  mid;
            if (nums[0] <= nums[mid]) {
                // 判断数据是否在前半部分
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    // 数据在后半部分
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                   // 数据在后半部分
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        _33_搜索旋转排序数组 o = new _33_搜索旋转排序数组();
        int [] nums = {4,5,6,7,0,1,2};
        System.out.print(o.search(nums,0));
    }
}
