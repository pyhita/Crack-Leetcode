package com.pyhita.utils;

import com.pyhita.LinkedList.entity.ListNode;

/**
 * @Author: kante_yang
 * @Date: 2024/3/12
 */
public class LinkedListUtils {

    public static ListNode generateList(int[] values) {

        ListNode dummy = new ListNode(0), tail = dummy;

        for (int value : values) {
            tail.next = new ListNode(value);
            tail = tail.next;
        }

        return dummy.next;
    }


}
