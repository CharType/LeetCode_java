package com.arithmetic.探索.快手;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class _138_复制带随机指针的链表 {

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        // 存储当前节点之前已经遍历过的节点，随机指针可能指向它们
        Map<Node,Node> map = new HashMap<>();
        // 存储当前节点之后的节点
        Map<Node,Node> map1 = new HashMap<>();
        Node newHead = new Node(-1);
        Node tranNode = newHead;
        Node node = head;
        while (node != null) {
            if(map1.containsKey(node)) {
                tranNode.next = map1.get(node);
            } else {
                tranNode.next = new Node(node.val);
            }

            if (node.random != null) {
                if (map.containsKey(node.random)) {
                    tranNode.random = map.get(node);
                } else {
                    Node node1 = node;
                    while (node1 != null) {
                        if (node.random == node1){
                            tranNode.random = new Node(node1.val);
                            map1.put(node1,tranNode.random);
                            break;
                        }
                        node1 = node1.next;
                    }
                }
            }
            map.put(node,tranNode);
            tranNode = tranNode.next;
            node = node.next;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        _138_复制带随机指针的链表 o = new _138_复制带随机指针的链表();
        Node head = new Node(7);
        Node head1 = new Node(13);
        head1.random = head;
        Node head2 = new Node(11);
        Node head3 = new Node(10);
        head2.random = head3;
        head3.random = head1;
        Node head4 = new Node(1);
        head4.random = head;
        Node newHead = o.copyRandomList(head);
        while (head != null && newHead != null) {
            if (!(head.val == newHead.val) && ((head.random == null && newHead.random == null) || (
                    head.random.val == newHead.random.val
                    ))) {

                System.out.println("测试不通过");
                break;
            }
            head = head.next;
            newHead = newHead.next;
        }
        System.out.println("测试通过");
    }
}
