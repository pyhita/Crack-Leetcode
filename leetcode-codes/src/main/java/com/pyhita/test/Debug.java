package com.pyhita.test;

/**
 * @Author: kante_yang
 * @Date: 2024/4/12
 */
public class Debug {


    public static void main(String[] args) {
        // int max = new Debug().maximalRectangle1(new char[][]{
        //     {'1', '1', '1', '1', '1', '1', '1', '1'},
        //     {'1', '1', '1', '1', '1', '1', '1', '0'},
        //     {'1', '1', '1', '1', '1', '1', '1', '0'},
        //     {'1', '1', '1', '1', '1', '0', '0', '0'},
        //     {'0', '1', '1', '1', '1', '0', '0', '0'}
        // });
        // System.out.println("max = " + max);
        String s = new String();
        s.split(",");
        System.out.println(new Debug().longestSubstring("bbaaacbd", 3));;
    }


    public int longestSubstring(String s, int k) {
        // 递归基，长度小于k 直接返回0即可
        if (s.length() < k) return 0;
        int[] counter = new int[26];

        // 初始化 计数器
        for (int i = 0;i < s.length();i++) {
            counter[s.charAt(i) - 'a']++;
        }

        // 拆分子问题，进行递归处理
        // 找到所有 出现次数小于k的字符，以其为分割点，分割子串，求解子串的解
        for (int i = 0;i < 26;i++) {
            if (counter[i] < k) {
                int res = 0;
                // 求解子串的解
                for (String t : s.split(((char) ('a' + i)) + "")) {

                }
            }
        }

        return s.length();
    }
}
