package com.arithmetic.精选Top面试题.中等;

import com.arithmetic.tools.Integers;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class _347_前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Node> map = new HashMap();
        PriorityQueue<Node> queue = new PriorityQueue(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.number - o1.number;
            }
        });

        for (int i = 0;i < nums.length;i++) {
            Node node = map.get(nums[i]);
            if (node == null) {
                node = new Node(nums[i],1);
                map.put(nums[i],node);
            } else {
                node.number = node.number + 1;
            }
            if (queue.isEmpty()) {
                queue.add(node);
            } else {
                if(queue.contains(node)) {
                    queue.remove(node);
                }
                queue.add(node);
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty() && list.size() < k) {
            Node node = queue.remove();
            list.add(node.val);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    class Node {
        int val;
        int number;
        Node(int val,int number) {
            this.val = val;
            this.number = number;
        }
    }
    public static void main(String[] args) {
//        int [] nums = {1,1,1,2,2,3};
//        int [] nums = {1,2};
        int [] nums = {3,0,1,0};
        _347_前K个高频元素 o = new _347_前K个高频元素();
        Integers.println(o.topKFrequent(nums,1));
    }
}
