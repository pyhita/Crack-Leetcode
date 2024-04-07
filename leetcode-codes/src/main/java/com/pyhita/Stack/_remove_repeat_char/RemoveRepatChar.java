package com.pyhita.Stack._remove_repeat_char;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author pyhita
 * @Date 2024/4/7
 * @Description
 */
public class RemoveRepatChar {

    public static void main(String[] args) {
        System.out.println(new RemoveRepatChar().remove("abbaaabcc"));
    }

    // 删除连续三个重复字母
    // abbaaabcc -> acc
    public String remove(String str) {
        Deque<CharWithCount> stack = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            if (stack.isEmpty() || c != stack.peek().c) {
                stack.push(new CharWithCount(c, 1));
                continue;
            }

            if (stack.peek().count == 2) {
                stack.pop();
                continue;
            }

            stack.peek().count++;
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            CharWithCount pop = stack.pop();
            for (int i = 0; i < pop.count; i++) {
                res.insert(0, pop.c);
            }
        }

        return res.toString();
    }

    public static class CharWithCount {
        public char c;
        public int count;

        public CharWithCount(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }


}
