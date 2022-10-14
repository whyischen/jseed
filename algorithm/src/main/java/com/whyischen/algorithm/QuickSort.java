package com.whyischen.algorithm;

import java.util.Arrays;

/**
 * 快速排序
 * </p>
 */
public class QuickSort {

    public static void sort(int[] array) {
        if (array == null) {
            return;
        }

        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (right <= left) {
            return;
        }

        int partitionIndex = partition(array, left, right);

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


    private static void swap(int[] array, int i1, int i2) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{6, 1, 5, 2, 9, 12, 3};

        sort(array);

        System.out.println(Arrays.toString(array));
    }

}
