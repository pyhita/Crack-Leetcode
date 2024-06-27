package com.pyhita.Sorting._148;

import com.pyhita.LinkedList.entity.ListNode;
import com.pyhita.utils.LinkedListUtils;

/**
 * @Author: kante_yang
 * @Date: 2024/4/24
 */
public class SortList {

    public static void main(String[] args) {
        ListNode head = LinkedListUtils.generateList(new int[]{4, 2, 1, 3});
        new SortList().sortList(head);
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        return sort(head);
    }

    private ListNode sort(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = findMid(head);
        ListNode next = mid.next;
        mid.next = null;

        sort(head);
        sort(next);
        return merge(head, next);
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode mergeHead = new ListNode(0), tail = mergeHead;

        while (h1 != null && h2 != null) {
            if (h1.val <= h2.val) {
                tail.next = h1;
                h1 = h1.next;
                tail = tail.next;
            } else {
                tail.next = h2;
                h2 = h2.next;
                tail = tail.next;
            }
        }

        if (h1 != null) tail.next = h1;
        if (h2 != null) tail.next = h2;

        return mergeHead.next;
    }

    private ListNode findMid(ListNode head) {
        ListNode fast = head.next, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

}
