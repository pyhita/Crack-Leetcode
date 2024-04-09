package com.pyhita.Stack._394_;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: kante_yang
 * @Date: 2024/3/27
 */
public class DecodeString {

    public static void main(String[] args) {
        System.out.println(new StringBuilder().toString());
    }

    public String decodeString(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        // num -> stack, ] stack pop
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (Character.isDigit(c)) {
                stack.push(c);
                i++;
            } else if (c == ']') {
                // stack pop until number
                while (!stack.isEmpty()) {
                    char pop = stack.pop();
                    if (Character.isDigit(pop)) {
                        for (int x = 1; x < pop - '0'; x++) {
                            String temp = sb.toString();
                            sb.append(temp);
                        }
                        break;
                    } else {
                        sb.insert(0, pop);
                    }
                }
                res.append(sb.toString());
                sb.setLength(0);
            } else {
                stack.push(c);
            }
        }

        return res.toString();
    }

}
