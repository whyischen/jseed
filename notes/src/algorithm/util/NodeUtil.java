package algorithm.util;

public class NodeUtil {
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

    public static ListNode array2ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        if (arr.length == 1) {
            return new ListNode(arr[0]);
        }
        var root = new ListNode(arr[0]);
        ListNode cur = root;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return root;
    }

    public static TreeNode array2Tree(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return new TreeNode();
        }
        return createTree(arr, 0);
    }

    private static TreeNode createTree(Integer[] array, int index) {
        if (index >= array.length) {
            return null;
        }

        Integer value = array[index];
        if (value == null) {
            return null;
        }

        var treeNode = new TreeNode(value);
        treeNode.left = createTree(array, 2 * index + 1);
        treeNode.right = createTree(array, 2 * index + 2);
        return treeNode;
    }
}
