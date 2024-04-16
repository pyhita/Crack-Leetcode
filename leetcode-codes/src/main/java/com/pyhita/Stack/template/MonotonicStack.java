package com.pyhita.Stack.template;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Author: kante_yang
 * @Date: 2024/4/16
 */
// 单调栈模板
public class MonotonicStack {

    public static void main(String[] args) {
        int[] ans = new int[]{3, 1, 2, 3};
        System.out.println(Arrays.toString(new MonotonicStack().lessRight1(ans)));
        System.out.println(Arrays.toString(new MonotonicStack().lessRight2(ans)));
        System.out.println(Arrays.toString(new MonotonicStack().greaterRight1(ans)));
        System.out.println(Arrays.toString(new MonotonicStack().greaterRight2(ans)));
    }

    // 下一个更小
    private int[] lessRight1(int[] ans) {
        int n = ans.length;
        Deque<Integer> stack = new ArrayDeque<>();

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && ans[i] < ans[stack.peek()]) {
                int pop = stack.pop();
                res[pop] = i;
            }

            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            if (res[i] == 0) res[i] = -1;
        }

        return res;
    }

    // 下一个更小
    private int[] lessRight2(int[] ans) {
        int n = ans.length;
        int[] res = new int[n];

        res[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < n && ans[j] >= ans[i]) {
                j = res[j];
            }

            res[i] = j;
        }

        for (int i = 0;i < n;i++) {
            if (res[i] == n) res[i] = -1;
        }

        return res;
    }

    // 下一个更大
    private int[] greaterRight1(int[] ans) {
        int n = ans.length;
        Deque<Integer> stack = new ArrayDeque<>();

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && ans[i] > ans[stack.peek()]) {
                int pop = stack.pop();
                res[pop] = i;
            }

            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            if (res[i] == 0) {
                res[i] = -1;
            }
        }

        return res;
    }

    // 下一个更大
    private int[] greaterRight2(int[] ans) {
        int n = ans.length;
        int[] res = new int[n];

        res[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < n && res[j] <= res[i]) {
                j = res[j];
            }

            res[i] = j;
        }

        for (int i = 0; i < n; i++) {
            if (res[i] == n) {
                res[i] = -1;
            }
        }

        return res;
    }
}
