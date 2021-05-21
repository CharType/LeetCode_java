package com.探索.头条.数据结构;

import java.util.HashMap;

public class _432_全O1的数据结构 {

}

class AllOne {
    private HashMap<String,Node> map;
    private String maxKey;
    private String minKey;
    /** Initialize your data structure here. */
    public AllOne() {
        this.map = new HashMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        Node node = this.map.get(key);
        if (node == null) {
            node = new Node(null,null,1,key);
            map.put(key,node);
        } else {
            node.value += 1;
            map.put(key,node);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        Node node = this.map.get(key);
        if (node != null) {
            if (node.value > 1) {
                node.value--;
            } else {
                map.remove(key);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return "";
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return "";
    }

    class Node {
        private Node next;
        private Node prev;
        private int value;
        private String key;
        public Node(Node next,Node prev,int value,String key) {
            this.next = next;
            this.prev = prev;
            this.value = value;
            this.key = key;
        }
    }

    public static void main(String[] args) {

    }
}
