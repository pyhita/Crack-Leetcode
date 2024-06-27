package com.pyhita.Stack._84_max_area;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: kante_yang
 * @Date: 2024/4/10
 */
public class MaxArea {

    public static void main(String[] args) {
        System.out.println(new MaxArea().largestRectangleArea(new int[]{1, 1}));

        TreeMap<Character, Integer> map = new TreeMap<>();
        Map<Character, Integer> m = null;

    }

    public int largestRectangleArea(int[] heights) {
        // 固定主矩形的高度，分别找到左边 和 右边第一个高度比它小的边界
        int n = heights.length;
        int[] left = new int[n], right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        // 构建right
        for (int i = 0;i < n;i++) {
            right[i] = i + 1;
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    int pop = stack.pop();
                    right[pop] = i;
                }
                stack.push(i);
            }
        }

        // 构建left
        stack.clear();
        for (int i = n-1;i >= 0;i--) {
            left[i] = i - 1;
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    int pop = stack.pop();
                    left[pop] = i;
                }
                stack.push(i);
            }
        }

        int max = 0;
        for (int i = 0;i < n;i++) {
            int h = heights[i];
            int w = right[i] - left[i] - 1;
            max = Math.max(max, h * w);
        }

        return max;
    }

    private boolean check(Map<Character, Integer> map, int k) {
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() < k) return false;
        }

        return true;
    }
}
