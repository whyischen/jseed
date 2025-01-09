package algorithm;

/**
 * 53. 最大子数组和
 * </p>
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 */
public class $53_MaxSubArray {

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        var currMax = nums[0];
        var max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // currMax = currMax + next元素
            // max函数用来判断 currMax 是负数的情况
            currMax = Math.max(currMax + nums[i], nums[i]);
            max = Math.max(max, currMax);
        }

        return max;
    }

    public static void main(String[] args) {
        var num1 = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("max:::: " + maxSubArray2(num1));
    }

}
