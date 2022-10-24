package com.whyischen.algorithm;

import com.whyischen.algorithm.util.NodeUtil;
import com.whyischen.algorithm.util.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 */
public class MaxPathSum {

    static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public static int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        var leftGain = Math.max(maxGain(node.left), 0);
        var rightGain = Math.max(maxGain(node.right), 0);

        int priceNewPath = node.val + leftGain + rightGain;
        maxSum = Math.max(priceNewPath, maxSum);

        return node.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        var arr = new Integer[]{-10, 9, 20, null, null, 15, 7};
        var root = NodeUtil.array2Tree(arr);
        System.out.println("maxPathSum::: " + maxPathSum(root));
    }


}
