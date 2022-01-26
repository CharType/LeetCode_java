package com.arithmetic.cq.source.tenxun;

import com.arithmetic.tools.Asserts;

import java.util.HashMap;
import java.util.Map;

class LRUCacheNode {
    public LRUCacheNode next;
    public LRUCacheNode prev;
    public Integer key;
    public int value;

    LRUCacheNode() {
        this.value = -1;
    }

    public String toString() {
        return value + " -> " + next;
    }
}

class LRUCache {
    Map<Integer, LRUCacheNode> map = new HashMap<>();
    int capactity;
    LRUCacheNode head;
    LRUCacheNode tail;

    public LRUCache(int capactity) {
        this.capactity = capactity;
        head = new LRUCacheNode();
        tail = new LRUCacheNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        LRUCacheNode node = map.get(key);
        if (node != null) {
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        LRUCacheNode node = map.get(key);
        if (node != null) {
            moveToHead(node);
            node.value = value;
        } else {
            LRUCacheNode newNode = new LRUCacheNode();
            newNode.value = value;
            newNode.key = key;
            newNode.next = head.next;
            head.next.prev = newNode;
            head.next = newNode;
            newNode.prev = head;
            map.put(key, newNode);
            if (map.size() > this.capactity) {
                // 删除尾部结点
                map.remove(tail.prev.key);
                removeNode(tail.prev);
            }
        }
    }

    // 将一个链表直接删除
    void removeNode(LRUCacheNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 将链表移动到链表的头部
    void moveToHead(LRUCacheNode node) {
        if (node.prev != null && node.next != null) {
            removeNode(node);
        }
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}

public class _146_LRU缓存 {


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);
        cache.put(1, 1);
        System.out.println(cache.head); // 1
        cache.put(2, 2);
        System.out.println(cache.head); // 2 1
        Asserts.test(cache.get(1) == 1); // 返回  1 // 1 2
        System.out.println(cache.head);
        cache.put(3, 3);    // 该操作会使得密钥 2 作废 // 3 1
        System.out.println(cache.head);
        Asserts.test(cache.get(1) == 1);       // 返回  1 3
        System.out.println(cache.head);
        cache.put(4, 4);    // 该操作会使得密钥 1 作废  // 41
        System.out.println(cache.head);
        Asserts.test(cache.get(1) == 1);       // 返回 -1 (未找到)
        System.out.println(cache.head); // 14
        Asserts.test(cache.get(3) == -1);       // 返回  -1
        System.out.println(cache.head);
        Asserts.test(cache.get(4) == 4);       // 返回  4  41
        System.out.println(cache.head);
        Asserts.test(cache.get(2) == -1);
        System.out.println(cache.head);
        cache.put(2, 6); // 6 4
        System.out.println(cache.head);
        Asserts.test(cache.get(1) == -1);
        System.out.println(cache.head);
        cache.put(1, 5);  // 5 6
        System.out.println(cache.head);
        Asserts.test(cache.get(2) == 6);
        System.out.println(cache.head);
        cache.put(1, 2);  // 1 6
        System.out.println(cache.head);
        Asserts.test(cache.get(1) == 2);
        System.out.println(cache.head);
        Asserts.test(cache.get(2) == 6);
        System.out.println(cache.head);
    }
}
