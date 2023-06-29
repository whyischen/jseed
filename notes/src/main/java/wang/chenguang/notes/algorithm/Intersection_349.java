package wang.chenguang.notes.algorithm;

import java.util.HashSet;

/**
 * 349. 两个数组的交集
 *
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 */
public class Intersection_349 {

    // 两个数组都转化成 set，然后比较是否包含
    public static int[] intersection(int[] nums1, int[] nums2) {
        var set1 = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        var resSet = new HashSet<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                resSet.add(nums2[i]);
            }
        }
        var res = new int[resSet.size()];
        var index = 0;
        for (var item : resSet) {
            res[index] = item;
            index++;
        }

        return res;
    }

}
