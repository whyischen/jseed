package com.whyischen.algorithm;

/**
 * 55. 跳跃游戏
 * <p>
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * <p>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 */
public class CanJump {

    /**
     * 每走一步都计算当前是否走到了终点，以及还可以走的步数
     * 当没有步数可以走，并且没有走到终点，游戏失败
     */
    public static boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        var curr = 0;
        var spare = 0;
        while (true) {
            // 已经走到终点
            if (curr >= nums.length - 1) {
                return true;
            }
            spare = Math.max(nums[curr], spare);
            curr++;
            spare--;
            // spare 为还可以走的步数
            // spare < 0 代表没有步数可以走了
            if (spare < 0) {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        var nums = new int[]{3, 0, 0, 0};
        System.out.println("canJump: " + canJump(nums));
    }


}
