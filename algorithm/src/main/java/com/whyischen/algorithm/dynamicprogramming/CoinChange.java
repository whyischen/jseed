package com.whyischen.algorithm.dynamicprogramming;

import java.util.Arrays;

/**
 * leetcode 322.凑零钱问题
 * 链接：https://leetcode-cn.com/problems/coin-change
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 */
public class CoinChange {

    private static int[] memo;

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int memoRes = getFromMemo(amount);
        if (memoRes != -777) {
            return memoRes;
        }

        int res = Integer.MAX_VALUE;

        for (int coin : coins) {
            int subProblem = coinChange(coins, amount - coin);
            if (subProblem == -1)
                continue;

            res = Math.min(res, subProblem + 1);
        }

        res = res == Integer.MAX_VALUE ? -1 : res;

        setMemo(amount, res);

        return res;
    }

    public static int getFromMemo(int amount) {
        if (memo == null) {
            memo = new int[amount + 1];
            Arrays.fill(memo, -777);
        }

        return memo[amount];
    }

    public static void setMemo(int amount, int res) {
        memo[amount] = res;
    }


    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        int[] coins = new int[]{1, 2, 5};
        int amount = 19200;

        System.out.println(">>>>>>>>>>>>>>>>>>>> " + coinChange(coins, amount));

        long endTime = System.currentTimeMillis();

        System.out.println(">>>>>>>>>>>>>>>>>>>> cost: " + (endTime - start) + "ms");
    }


}
