package com.arithmetic.探索.快手;

import com.arithmetic.tools.Asserts;

import java.util.HashMap;
import java.util.Map;

class LRUCacheNode {
    public int key;
    public int value;
    public LRUCacheNode next;
    public LRUCacheNode prev;
    LRUCacheNode(){
        this.value = -1;
    }
    public String toString() {
        return value + " -> " + next;
    }
}

class LRUCache {
    Map<Integer,LRUCacheNode> map = new HashMap<>();
    public int capactity;
    public LRUCacheNode head;
    public LRUCacheNode trail;
    public LRUCache(int capacity) {
        this.capactity = capacity;
        this.head = new LRUCacheNode();
        this.trail = new LRUCacheNode();
        this.head.next = this.trail;
        this.trail.prev = this.head;
    }


    public int get(int key) {
        LRUCacheNode node = map.get(key);
        if (node != null) {
            removeNode(node);
            moveNodeTOHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        LRUCacheNode node = map.get(key);
        if (node != null) {
            node.value = value;
            moveNodeTOHead(node);
        } else {
            node = new LRUCacheNode();
            node.value = value;
            node.key = key;
            moveNodeTOHead(node);
        }
        map.put(key,node);
        if (map.size() > capactity) {
            map.remove(trail.prev.key);
            removeNode(trail.prev);
        }

    }

    public void moveNodeTOHead(LRUCacheNode node) {
        if (node.prev != null && node.next != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }


        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public void removeNode(LRUCacheNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }
}

public class _146_LRU缓存机制 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
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
        cache.put(2,6); // 6 4
        System.out.println(cache.head);
        Asserts.test(cache.get(1) == -1);
        System.out.println(cache.head);
        cache.put(1,5);  // 5 6
        System.out.println(cache.head);
        Asserts.test(cache.get(2) == 6);
        System.out.println(cache.head);
        cache.put(1,2);  // 1 6
        System.out.println(cache.head);
        Asserts.test(cache.get(1) == 2);
        System.out.println(cache.head);
        Asserts.test(cache.get(2) == 6);
        System.out.println(cache.head);
    }
}
