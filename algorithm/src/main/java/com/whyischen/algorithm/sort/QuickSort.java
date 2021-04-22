package com.whyischen.algorithm.sort;

import java.util.Arrays;

/**
 * @author wangchenguang
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
        int pivot = left;
        int index = pivot + 1;

        for (int i = index; i <= right; i++) {
            if (array[i] < array[pivot]) {
                swap(array, i, index);
                index++;
            }
        }

        swap(array, pivot, index - 1);

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
