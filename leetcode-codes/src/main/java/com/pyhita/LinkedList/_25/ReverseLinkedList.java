package com.pyhita.LinkedList._25;

import com.pyhita.LinkedList.entity.ListNode;

/**
 * @Author: kante_yang
 * @Date: 2024/3/8
 */
public class ReverseLinkedList {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head ==  null || head.next == null) return head;
        ListNode dummy = new ListNode(0, head);
        int len = 0;
        for (ListNode temp = head; temp != null; temp = temp.next) len++;

        ListNode cur = head, prev = dummy;
        while (len > k) {
            len -= k;

            ListNode newHead = null, tail = cur;
            for (int i = 1; i < k; i++) {
                ListNode next = cur.next;
                cur.next = newHead;
                newHead = cur;
                cur = next;
            }

            prev.next = newHead;
            tail.next = cur;
            prev = tail;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode h1 = new ListNode(2, null);
        ListNode h2 = new ListNode(3, null);
        head.next = h1;
        h1.next = h2;
        // head.next.next = new ListNode(2, )

        reverseKGroup(head, 2);
    }

}
