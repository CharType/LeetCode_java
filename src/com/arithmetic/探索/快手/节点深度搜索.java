package com.arithmetic.探索.快手;

import java.util.ArrayList;
import java.util.List;

class Node1 {
    int value;
    List<Node1> subNodes;
    public Node1(int value) {
        this.value = value;
    }
}
public class 节点深度搜索 {

    public static void main(String[] args) {
        Node1 v1Node = new Node1(1);
        Node1 v2Node = new Node1(2);
        Node1 v3Node = new Node1(3);
        Node1 v4Node = new Node1(4);
        List<Node1> list1 = new ArrayList<>();
        list1.add(v2Node);
        list1.add(v3Node);
        list1.add(v4Node);
        v1Node.subNodes = list1;

        Node1 v5Node = new Node1(5);
        Node1 v6Node = new Node1(6);
        List<Node1> list2 = new ArrayList<>();
        list2.add(v5Node);
        list2.add(v6Node);
        v2Node.subNodes = list2;

        test(v1Node,0);


    }

    public static void test (Node1 root,int count) {
        if (root == null) return;
        StringBuilder sb = new StringBuilder();
        int num = count;
        while (num > 0) {
            sb.append("-");
            num--;
        }
        sb.append(root.value);
        System.out.println(sb.toString());
        for (int i = 0;root.subNodes != null && i < root.subNodes.size();i++) {
            Node1 node = root.subNodes.get(i);
            test(node,count+1);
        }

        return;
    }
}
