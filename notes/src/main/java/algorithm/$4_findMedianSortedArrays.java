package algorithm;

public class $4_findMedianSortedArrays {

    public static void main(String[] args) {
        double res = findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println("题目: findMedianSortedArrays, 预期: 2.5, 实际: " + res);
    }

    /**
     * 4.寻找两个正序数组的中位数
     * <p>
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     * <p>
     * 算法的时间复杂度应该为 O(log (m+n)) 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     * 示例 2：
     * <p>
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     * <p>
     * 提示：
     * <p>
     * nums1.length == m
     * nums2.length == n
     * 0 <= m <= 1000
     * 0 <= n <= 1000
     * 1 <= m + n <= 2000
     * -106 <= nums1[i], nums2[i] <= 106
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // 最后有两个数要不要相除得问题，可以使用双指针记录
        // 我得思路被禁锢在要使用两个数组记录了

        int maxLength = nums1.length + nums2.length;
        int targetIndex = maxLength / 2;
        boolean needsDivide = maxLength % 2 == 0;

        int index = 0;
        int i1 = 0;
        int i2 = 0;
        double last = -1;
        double cur = -1;
        while (index <= targetIndex) {
            last = cur;
            // nums1 有数并且小于 nums2最小的数
            if (i2 >= nums2.length || (i1 < nums1.length && nums1[i1] < nums2[i2])) {
                cur = nums1[i1];
                i1++;
            } else {
                cur = nums2[i2];
                i2++;
            }
            index++;
        }
        return needsDivide ? (last + cur) / 2 : cur;
    }


}
