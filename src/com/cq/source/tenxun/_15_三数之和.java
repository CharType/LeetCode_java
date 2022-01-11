package com.cq.source.tenxun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        // 遍历整个数组
        for (int first = 0; first < n; first++) {
            // 如果当前数字和上次一样，直接跳过
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // 第三个数字指针在最右侧
            int third = n - 1;
            // 第一个数字，后两个数字相加等于第一个数字的负数 那么三个数相加的结果就是0
            int target = -nums[first];
            for (int second = first + 1; second < n; second++) {
                // 第二个数字和上次遍历的一样 直接跳过
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                // 如果第二个数字 + 第三个数字 大于第一个数字 那么移动第三个数字的指针
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                // 第二个指针和第是哪个指针相遇了 说明结果都遍历过，在遍历也是重复的
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        _15_三数之和 o = new _15_三数之和();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(o.threeSum(nums));
    }
}
