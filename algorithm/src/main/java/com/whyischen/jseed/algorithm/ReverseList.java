package com.whyischen.jseed.algorithm;

import lombok.ToString;

/**
 * 反转链表
 */
public class ReverseList {

    @ToString
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {

        if (head.next == null) {
            return head;
        }

        var last = reverse(head.next);

        head.next.next = head;
        head.next = null;

        return last;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(10111);
        ListNode temp = null;

        int size = 2;

        for (int i = 0; i < size; i++) {
            ListNode node = new ListNode(i);

            if (temp == null) {
                head.next = node;
                temp = node;
                continue;
            }

            temp.next = node;
            temp = node;
        }

        printNode(head);

        ListNode reverse = reverse(head);

        printNode(reverse);
    }

    public static void printNode(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode temp = head;

        StringBuilder print = new StringBuilder(head.val + "");

        while (temp.next != null) {
            temp = temp.next;
            print.append(" -> ").append(temp.val);
        }

        System.out.println(print);
    }

}
