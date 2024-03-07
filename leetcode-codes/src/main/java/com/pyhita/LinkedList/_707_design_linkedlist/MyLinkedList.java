package com.pyhita.LinkedList._707_design_linkedlist;


import com.pyhita.LinkedList.entity.ListNode;

/**
 * @Author: kante_yang
 * @Date: 2024/3/7
 */
class MyLinkedList {

    private ListNode head;
    private int size;

    public MyLinkedList() {
        head = new ListNode(0);
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;

        ListNode cur = head;
        for (int i = 0;i <= index;i++) {
            cur = cur.next;
        }

        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;

        size++;
        ListNode prev = head;
        for (int i = 0;i < index;i++) {
            prev = prev.next;
        }

        prev.next = new ListNode(val, prev.next);
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        size--;
        ListNode prev = head;
        for (int i = 0;i < index;i++) {
            prev = prev.next;
        }

        prev.next = prev.next.next;
    }
}
