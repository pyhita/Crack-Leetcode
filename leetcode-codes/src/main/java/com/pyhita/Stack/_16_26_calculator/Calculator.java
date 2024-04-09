package com.pyhita.Stack._16_26_calculator;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: kante_yang
 * @Date: 2024/4/8
 */
public class Calculator {

    public static void main(String[] args) {
        System.out.println(new Calculator().calculate("32+2*2"));
    }

    public int calculate(String s) {
        // 3+2*2
        // 数字或者栈空：直接入栈
        // 运算符两种情况：
        // 当前 <= 栈顶，出栈运算
        // 当前 > 栈顶 入符号栈

        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Character> ops = new ArrayDeque<>();
        int n = s.length(), i = 0;

        while (i < n) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int sum = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    sum = sum * 10 + (s.charAt(i++) - '0');
                }
                nums.push(sum);
            } else if (c == ' ') {
                i++;
            } else {
                if (ops.isEmpty() || isPrior(c, ops.peek())) {
                    ops.push(c);
                } else {
                    while (!ops.isEmpty() && !isPrior(c, ops.peek())) {
                        fetchAndCal(nums, ops);
                    }
                    ops.push(c);
                }
                i++;
            }
        }

        while (!ops.isEmpty()) {
            fetchAndCal(nums, ops);
        }

        return nums.pop();
    }

    private boolean isPrior(char c, char d) {
        if (((c == '*') || (c == '/'))
            && ((d == '+') || (d == '-'))) return true;

        return false;
    }

    private void fetchAndCal(Deque<Integer> nums, Deque<Character> ops) {
        int a = nums.pop();
        int b = nums.pop();
        char op = ops.pop();

        switch (op) {
            case '+': nums.push(a + b);
            case '-': nums.push(b - a);
            case '*': nums.push(a * b);
            case '/': nums.push(b / a);
        }
    }

}
