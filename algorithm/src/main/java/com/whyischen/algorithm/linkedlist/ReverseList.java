package com.whyischen.algorithm.linkedlist;

public class ReverseList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ListNode listNode = (ListNode) o;

            return val == listNode.val;
        }

        @Override
        public int hashCode() {
            return val;
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

    /**
     * 反转链表，迭代实现
     *
     * @param head
     * @return
     */
    public static ListNode reverse2(ListNode head) {

        ListNode pre = null, cur = head, next = null;

        while (cur != null) {
            next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    /**
     * 反转区间 [a, b) 的元素，注意是左闭右开
     */
    public static ListNode reverse(ListNode a, ListNode b) {
        if (a.equals(b)) {
            return a;
        }

        ListNode pre = null, cur = a, next = null;

        while (!cur.equals(b)) {

            next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    /**
     * k 个一组反转链表
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) return head;
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }


    public static void main(String[] args) {

        ListNode head = buildList(10);

        head = reverseKGroup(head, 3);

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
