package com.arithmetic.探索.快手;

/**
 *https://leetcode-cn.com/problems/validate-ip-address/
 * 对于 IPv4 地址，通过界定符 . 将地址分为四块；对于 IPv6 地址，通过界定符 : 将地址分为八块。
 *
 * 对于 IPv4 地址的每一块，检查它们是否在 0 - 255 内，且没有前置零。
 *
 * 对于 IPv6 地址的每一块，检查其长度是否为 1 - 4 位的十六进制数。
 */
public class _468_验证IP地址 {

    // 验证IPV4地址的有效性
    public String validIPV4Address(String IP) {
        String [] ips = IP.split("\\.",-1);
        for (String ip : ips) {
            // 长度是否正确
            if (ip.length() == 0 || ip.length() > 3) return "Neither";
            // 2. 是否是0开头
            if (ip.charAt(0) == '0' && ip.length() != 1) return "Neither";
            // 3. 是否是其他字符
            for (char ch : ip.toCharArray()) {
                if (! Character.isDigit(ch)) return "Neither";
            }
            // 4. 是否大于255
            if (Integer.parseInt(ip) > 255) return "Neither";
        }
        return "IPv4";
    }
    // 验证是否是IPV6
    public String validIPV6Address(String IP) {
        String [] ips = IP.split(":",-1);
        String hexdigits = "0123456789abcdefABCDEF";
        for (String ip : ips) {
            if (ip.length() == 0 || ip.length() > 4) return "Neither";
            for (char ch : ip.toCharArray()) {
                if (hexdigits.indexOf(ch)== -1) return "Neither";
            }
        }
        return "IPv6";
    }

    public String validIPAddress(String IP) {
        if (IP.split("\\.").length == 4) {
            return validIPV4Address(IP);
        } else if (IP.split(":").length == 8) {
            return validIPV6Address(IP);
        } else {
            return "Neither";
        }
    }

    public static void main(String[] args) {
        _468_验证IP地址 o = new _468_验证IP地址();
//        System.out.println(o.validIPAddress("172.16.254.1"));
//        System.out.println(o.validIPAddress("172.16.256.1"));
//        System.out.println(o.validIPAddress("017.16.256.1"));

        System.out.println(o.validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334"));
        System.out.println(o.validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334"));
        System.out.println(o.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));

    }
}
