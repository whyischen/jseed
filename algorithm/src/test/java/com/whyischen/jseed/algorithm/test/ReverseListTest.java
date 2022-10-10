package com.whyischen.jseed.algorithm.test;

import com.whyischen.jseed.algorithm.ReverseList;
import com.whyischen.jseed.algorithm.util.ListNode;
import com.whyischen.jseed.algorithm.util.NodeUtil;
import org.junit.jupiter.api.Test;


public class ReverseListTest {

    @Test
    public void testReverseList() {
        ListNode head = new ListNode(0);
        ListNode temp = null;

        int size = 5;
        for (int i = 1; i <= size; i++) {
            ListNode node = new ListNode(i);
            if (temp == null) {
                head.next = node;
                temp = node;
                continue;
            }
            temp.next = node;
            temp = node;
        }

        NodeUtil.printNode(head);
        ListNode reverse = ReverseList.reverseList2(head);
        NodeUtil.printNode(reverse);
    }


}
