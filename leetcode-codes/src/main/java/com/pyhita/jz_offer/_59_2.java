package com.pyhita.jz_offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: kante_yang
 * @Date: 2024/4/11
 */
public class _59_2 {

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();

        maxQueue.push_back(1);
        maxQueue.push_back(2);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());

        List<Integer> res = new ArrayList<>();
        res.toArray();
    }

    public static class MaxQueue {
        // 存放队列值
        private Deque<Integer> queue1;
        // 存放最大值
        private Deque<Integer> queue2;
        public MaxQueue() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        public void push_back(int value) {
            queue1.offer(value);

            // 最大值进queue2
            while (!queue2.isEmpty() && value > queue2.peekLast()) {
                queue2.pollLast();
            }
            queue2.offerLast(value);
        }

        public int max_value() {
            if (queue1.isEmpty()) return -1;

            return queue2.peek();
        }

        public int pop_front() {
            if (queue1.isEmpty()) {
                return -1;
            }

            int poll = queue1.poll();
            if (poll == queue2.peek()) {
                queue2.poll();
            }

            return poll;
        }
    }

}
