package wang.chenguang.learn.algorithm;

import wang.chenguang.learn.algorithm.util.ListNode;
import wang.chenguang.learn.algorithm.util.NodeUtil;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class AddTwoNumbers_2 {

    public static void main(String[] args) {
        var l1 = NodeUtil.array2ListNode(new int[]{2,4,3});
        var l2 = NodeUtil.array2ListNode(new int[]{5,6,4});

        NodeUtil.printNode(addTwoNumbers(l1, l2));
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int addTemp = 0;
        ListNode root = null;
        ListNode cur = null;

        while (true) {
            if (l1 == null && l2 == null) {
                if (addTemp != 0) {
                    cur.next = new ListNode(addTemp);
                }
                break;
            }

            int val = 0;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            if (addTemp != 0) {
                val += addTemp;
                addTemp = 0;
            }
            if (val >= 10) {
                addTemp = 1;
                val -= 10;
            }
            if (root == null) {
                root = new ListNode(val);
                cur = root;
            } else {
                cur.next = new ListNode(val);
                cur = cur.next;
            }
        }

        return root;
    }
}
