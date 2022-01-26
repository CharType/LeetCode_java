package com.arithmetic.cq.source.list.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/single-number-ii/
 * //给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：nums = [2,2,3,2]
 * //输出：3
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：nums = [0,1,0,1,0,1,100]
 * //输出：100
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= nums.length <= 3 * 10⁴
 * // -2³¹ <= nums[i] <= 2³¹ - 1
 * // nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 * //
 * //
 * //
 * //
 * // 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class _137_只出现一次的数字II {
    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer n = map.getOrDefault(nums[i], 0);
            map.put(nums[i], n + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(), occ = entry.getValue();
            if (occ == 1) {
                ans = num;
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 0, 1, 100};
        System.out.println(singleNumber(nums));
    }
}
