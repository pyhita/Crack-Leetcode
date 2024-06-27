package com.pyhita.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: kante_yang
 * @Date: 2024/3/20
 */
public class DequeTest {

    public static void main(String[] args) {
        List<String> ips = new DequeTest().restoreIpAddresses("101023");
        System.out.println(ips);

        StringBuilder sb = new StringBuilder();
        sb.append(22).append('c').append('c');
        System.out.println(sb.toString());
        sb.setLength(sb.length() - 2);
        System.out.println(sb.toString());
        sb.append('c');
        System.out.println(sb.toString());
    }

    // private List<String> res;
    // public List<String> restoreIpAddresses(String s) {
    //     this.res = new ArrayList<>();
    //
    //     dfs(s.toCharArray(), new StringBuilder(), 0, 0);
    //     String path = new String();
    //     path.substring(1);
    //     return res;
    // }
    //
    // private void dfs(char[] ips, StringBuilder sb, int size, int index) {
    //     if (size == 3) {
    //         if (index >= ips.length) return;
    //         if (ips[index] == '0' && index != ips.length - 1) return;
    //
    //         int num = 0, start = index;
    //         while (index < ips.length) {
    //             num = num * 10 + (ips[index++] - '0');
    //         }
    //
    //         if (num <= 255) {
    //             sb.append(num);
    //             res.add(sb.toString());
    //             sb.setLength(sb.length() - (index - start));
    //         }
    //         return;
    //     }
    //
    //     // 0; 一位数，两位数，三位数(是不是小于255)
    //     if (ips[index] == '0') {
    //         sb.append(ips[index]).append('.');
    //         dfs(ips, sb, size + 1, index + 1);
    //         sb.setLength(sb.length() - 2);
    //     } else {
    //         int num = 0, start = index;
    //         for (int i = 1; i <= 3; i++) {
    //             if (index + i - 1 >= ips.length) break;
    //
    //             num = num * 10 + (ips[index + i - 1] - '0');
    //             if (num <= 255) {
    //                 sb.append(num).append('.');
    //                 dfs(ips, sb, size + 1, index + i);
    //                 sb.setLength(sb.length() - (i + 1));
    //             } else {
    //                 break;
    //             }
    //         }
    //     }
    // }


    private List<String> res;
    public List<String> restoreIpAddresses(String s) {
        this.res = new ArrayList<>();

        dfs(s, 0, 0, "");
        return res;
    }

    private void dfs(String s, int start, int size, String path) {
        if (start >= s.length()) return;
        if (size == 3) {
            // check last str valid ?
            char c = s.charAt(start);
            if (c == '0' && start != s.length() - 1) return;
            int num = 0;

            while (start < s.length()) {
                num = num * 10 + (s.charAt(start) - '0');
            }

            if (num <= 255) {
                res.add(new String(path + num));
            }
            return;
        }

        char c = s.charAt(start);
        if (c == '0') {
            dfs(s, start + 1, size + 1, path + c + ".");
        } else {
            int num = 0;
            for (int index = start;index < s.length();index++) {
                num = num * 10 + (s.charAt(index) - '0');

                if (num <= 255) {
                    dfs(s, index + 1, size + 1, path + num + ".");
                } else {
                    break;
                }
            }
        }

    }


}
