package com.arithmetic.other;

/**
 * https://leetcode-cn.com/problems/defanging-an-ip-address/
 */
public class _1108_IP_地址无效化 {

    public String defangIPaddr(String address) {
        if (address == null) return null;
        char [] chars = address.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i <chars.length;i++) {
            if (chars[i] != '.') {
                sb.append(chars[i]);
            } else {
                sb.append('[');
                sb.append('.');
                sb.append(']');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _1108_IP_地址无效化 o = new _1108_IP_地址无效化();
        System.out.println(o.defangIPaddr("127.0.1.1"));
    }
}
