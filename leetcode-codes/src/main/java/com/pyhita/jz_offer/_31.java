package com.pyhita.jz_offer;

/**
 * @Author: kante_yang
 * @Date: 2024/4/9
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 offer 31， 栈的压入和弹出序列
 */
public class _31 {

    public static void main(String[] args) {
        System.out.println(new _31().solve(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
    }

    public boolean validateStackSequences(int[] pushed,int[] popped){
        int push = 0, pop = 0;
        for(int i = 0; i < pushed.length; i++){
            pushed[push] = pushed[i];
            while(push >= 0 && pushed[push] == popped[pop]){
                push--; pop++;
            }
            push++;
        }
        return push == 0;
    }

    // pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
    public boolean solve(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        for (int push : pushed) {
            // 压入栈中
            stack.push(push);
            // 发现可以出栈的元素，进行出栈
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }

        return stack.isEmpty();
    }
}
