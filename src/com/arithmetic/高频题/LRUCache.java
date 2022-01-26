package com.arithmetic.高频题;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer, ListNode> map;
    int capacity;
    ListNode firstNode;
    ListNode lastNode;
    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        this.capacity = capacity;
        this.firstNode = new ListNode();
        this.lastNode = new ListNode();
        this.firstNode.next = this.lastNode;
        this.lastNode.prev = this.firstNode;
    }

    public int get(int key) {
        ListNode node = map.get(key);
        if (node == null) return -1;
        removeNode(node);
        addAfeterNodee(node);
        return node.value;
    }

    private void addAfeterNodee(ListNode node) {
        node.next = this.firstNode.next;
        node.next.prev = node;

        this.firstNode.next = node;
        node.prev = this.firstNode;
    }

    private void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void put(int key, int value) {
        ListNode node = map.get(key);
        if (node != null) {
            node.value = value;
            removeNode(node);
        } else {
            if (map.size() >= capacity) {
                // 删除不经常使用的数据，腾出位置
                map.remove(this.lastNode.prev.key);
                removeNode(this.lastNode.prev);
            }
            node = new ListNode(key,value);
        }
        map.put(key,node);
        addAfeterNodee(node);
    }
}

class ListNode {
    public Integer key;
    public Integer value;
    public ListNode next;
    public ListNode prev;

    public ListNode(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public ListNode(){};
}
