package com.pyhita.utils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * @Author: kante_yang
 * @Date: 2024/3/20
 */
public class DequeTest {

    public static void main(String[] args) {

        // Deque<Integer> stack = new ArrayDeque<>();
        // stack.push(1);
        // stack.push(2);
        // stack.push(3);
        //
        // // peek
        // System.out.println(stack.peek());
        //
        // // pop
        // while (!stack.isEmpty()) {
        //     System.out.println(stack.pop());
        // }

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);

        System.out.println("top " + deque.peek());
        while (!deque.isEmpty()) {
            System.out.println(deque.poll());
        }

        Map<Character, Character> map = Map.of('c', 'c', 'c', 'c');
        String x = "ss";
    }

}
