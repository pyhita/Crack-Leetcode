package com.pyhita.LinkedList._19_remove_nth_from_end;

import com.pyhita.LinkedList.entity.ListNode;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy, fast = dummy;

        // fast point move n steps
        while (n-- > 0) {
            fast = fast.next;
        }

        // fast, slow go together
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}