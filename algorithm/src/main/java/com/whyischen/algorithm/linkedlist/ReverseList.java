package com.whyischen.algorithm.linkedlist;

public class ReverseList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    private static ListNode successor;

    /**
     * 反转链表
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

    /**
     * 反转链表前N个节点
     */
    public static synchronized ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }

        var last = reverseN(head.next, n - 1);

        head.next.next = head;
        head.next = successor;
        return last;
    }

    /**
     * 反转链表的一部分
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }

        head.next = reverseBetween(head.next, m - 1, n - 1);

        return head;
    }


    public static void main(String[] args) {

        ListNode head = buildList(10);

        head = reverseBetween(head, 2, 5);

        printNode(head);
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

    public static ListNode buildList(int size) {

        ListNode head = new ListNode(0);

        if (size <= 1) {
            return head;
        }

        ListNode temp = null;
        for (int i = 1; i < size; i++) {
            ListNode node = new ListNode(i);

            if (temp == null) temp = head;

            temp.next = node;
            temp = node;
        }

        return head;
    }

}
