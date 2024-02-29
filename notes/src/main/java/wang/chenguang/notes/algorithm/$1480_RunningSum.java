package wang.chenguang.notes.algorithm;

import java.util.Arrays;

public class $1480_RunningSum {

    public static void main(String[] args) {
        var nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(runningSum(nums)));
    }

    /**
     * 1480. 一维数组的动态和
     * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
     * 请返回 nums 的动态和。
     * <p>
     * 示例 1：
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,6,10]
     * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
     */
    public static int[] runningSum(int[] nums) {
        var res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (i > 0) {
                temp += res[i - 1];
            }
            res[i] = temp;
        }
        return res;
    }

}
