package com.探索.快手;

import java.util.PriorityQueue;

public class _1046_最后一块石头的重量 {
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) return 0;
        if (stones.length == 1) return stones[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int i = 0;i < stones.length;i++) {
            queue.add(stones[i]);
        }
        while (!queue.isEmpty()) {
            if (queue.size() == 1) {
                return queue.peek();
            }
            int num1 = queue.remove();
            int num2 = queue.remove();
            if (num1 > num2) {
                queue.add(num1 -  num2);
            }
        }
        if (queue.isEmpty()) return 0;
        return queue.peek();
    }

    public static void main(String[] args) {
        int [] nums = {2,7,4,1,8,1};
        _1046_最后一块石头的重量 o = new _1046_最后一块石头的重量();
        System.out.println(o.lastStoneWeight(nums));
    }
}
