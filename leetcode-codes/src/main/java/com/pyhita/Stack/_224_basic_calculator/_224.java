package com.pyhita.Stack._224_basic_calculator;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: kante_yang
 * @Date: 2024/4/13
 */
public class _224 {

    public static void main(String[] args) {
        System.out.println(new _224().calculate("-2 * 3 + 9 + (-2 + 1)"));;
    }


    Deque<Integer> nums = new ArrayDeque<>();
    Deque<Character> ops = new ArrayDeque<>();
    public int calculate(String s) {
        int n = s.length();
        char[] tokens = s.toCharArray();

        int i = 0;
        boolean needZero = true;
        while (i < n) {
            char token = tokens[i];

            if (Character.isDigit(token)) {
                int val = 0;
                while (i < n && Character.isDigit(tokens[i])) {
                    val = val * 10 + (tokens[i] - '0');
                    i++;
                }
                nums.push(val);
                needZero = false;
            } else if (token == '(') {
                ops.push(token);
                needZero = true;
                i++;
            } else if (token == ')') {
                while (ops.peek() != '(') {
                    fetcchAndCal();
                }
                ops.pop();
                needZero = false;
                i++;
            } else if (token == ' ') {
                i++;
            } else {
                if ((token == '+' || token == '-') && needZero) nums.push(0);
                while (!ops.isEmpty() && (getRank(ops.peek()) >= getRank(token))) {
                    // 出栈计算
                    fetcchAndCal();
                }
                ops.push(token);
                needZero = true;
                i++;
            }
        }

        while (!ops.isEmpty()) {
            fetcchAndCal();
        }

        return nums.pop();
    }

    private int getRank(char c) {
        if (c == '*' || c == '/') return 2;
        if (c == '+' || c == '-') return 1;

        return 0;
    }

    private void fetcchAndCal() {
        int a = nums.pop();
        int b = nums.pop();
        char op = ops.pop();

        switch(op) {
            case '+':
                nums.push(a + b);
                break;
            case '-':
                nums.push(b - a);
                break;
            case '*':
                nums.push(a * b);
                break;
            case '/':
                nums.push(b / a);
                break;
        }
    }


}
