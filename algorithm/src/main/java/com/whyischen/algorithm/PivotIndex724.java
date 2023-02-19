package com.whyischen.algorithm;

/**
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 * <p>
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 */
public class PivotIndex724 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, -1, -6};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 1; i < nums.length; i++) {
            rightCount += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (leftCount == rightCount) {
                return i;
            }
            if (i == nums.length - 1) {
                break;
            }

            leftCount += nums[i];
            rightCount -= nums[i + 1];
        }

        return -1;
    }

}
