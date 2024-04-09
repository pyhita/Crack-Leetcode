package com.pyhita.company.bytedance.odd_rising_even_falling_list;

import com.pyhita.LinkedList.entity.ListNode;
import com.pyhita.utils.LinkedListUtils;

/**
 * @Author: kante_yang
 * @Date: 2024/3/12
 * link: https://mp.weixin.qq.com/s/0WVa2wIAeG0nYnVndZiEXQ
 */
public class OddRisingEvenFallingLinkedList {

    public static void main(String[] args) {
        ListNode head = LinkedListUtils.generateList(new int[]{1, 8, 3, 6, 5, 4, 7, 2});
        ListNode res = new OddRisingEvenFallingLinkedList().process(head);
        System.out.println();
    }

    public ListNode process(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 1 拆分链表
        ListNode odd = new ListNode(0), oddTail = odd;
        ListNode even = new ListNode(0), evenTail = even;

        ListNode cur = head;
        while (cur != null && cur.next != null) {
            oddTail.next = cur;
            oddTail = oddTail.next;
            evenTail.next = cur.next;
            evenTail = evenTail.next;
            cur = cur.next.next;
        }
        evenTail.next = null;
        oddTail.next = null;
        if (cur != null) {
            oddTail.next = cur;
            oddTail = oddTail.next;
        }

        // 2 反转链表
        ListNode newHead = reverse(even.next);
        even.next = null;

        // 3 合并有序链表
        return merge(odd.next, newHead);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0), tail = dummy;

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                tail.next = head1;
                tail = tail.next;
                head1 = head1.next;
            } else {
                tail.next = head2;
                tail = tail.next;
                head2 = head2.next;
            }
        }

        if (head1 != null) {
            tail.next = head1;
        }
        if (head2 != null) {
            tail.next = head2;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;
    }



}
