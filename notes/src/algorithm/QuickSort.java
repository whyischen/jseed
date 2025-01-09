package algorithm;

import java.util.Arrays;

/**
 * 快速排序
 * </p>
 */
public class QuickSort {

    public static void main(String[] args) {
//        int[] array = new int[]{5, 1, 6, 9, 2, 12, 3};
        int[] array = new int[]{6, 1, 2, 9, 12, 5, 7};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }

    public static void quickSort(int[] array, int left, int right) {
        if (right <= left) {
            return;
        }

        int partitionIndex = partition2(array, left, right);

        quickSort(array, left, partitionIndex - 1);
        quickSort(array, partitionIndex + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (array[i] < array[left]) {
                swap(array, i, index);
                index++;
            }
        }

        swap(array, left, index - 1);

        return index - 1;
    }

    /**
     * 以 pivot 的值大小拆分数组，数组左边都小于 pivot，数组右边都大于 pivot
     * i 和 j 两个指针分别从左右向中间出发，i 寻找比 pivot 大的数， j 寻找比 pivot 小的数
     * 交换 i 和 j 位置元素的值
     * 终止条件：i 与 j 相遇
     */
    private static int partition2(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        // 关于区间的边界控制需格外小心，稍有不慎就会出错
        // 我这里把 i, j 定义为开区间，同时定义：
        // [lo, i) <= pivot；(j, hi] > pivot
        // 之后都要正确维护这个边界区间的定义
        int i = lo + 1, j = hi;
        // 当 i > j 时结束循环，以保证区间 [lo, hi] 都被覆盖
        while (i <= j) {
            while (i < hi && nums[i] <= pivot) {
                i++;
                // 此 while 结束时恰好 nums[i] > pivot
            }
            while (j > lo && nums[j] > pivot) {
                j--;
                // 此 while 结束时恰好 nums[j] <= pivot
            }
            // 此时 [lo, i) <= pivot && (j, hi] > pivot

            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        // 将 pivot 放到合适的位置，即 pivot 左边元素较小，右边元素较大
        swap(nums, lo, j);
        return j;
    }


    private static void swap(int[] array, int i1, int i2) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

}