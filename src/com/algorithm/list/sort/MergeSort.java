package com.algorithm.list.sort;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] str = {4, 5, 1, 6, 2, 7, 3, 8};
        mergeSort(str);
        Utils.print(str);
    }

    public static void mergeSort(int[] list) {
        if (list.length > 1) {
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            int[] temp = merge(firstHalf, secondHalf);
            System.arraycopy(temp, 0, list, 0, temp.length);

        }
    }

    private static int[] merge(int[] firstHalf, int[] secondHalf) {
        int[] temp = new int[firstHalf.length + secondHalf.length];

        int leftIndex = 0; //左序列下标
        int rightIndex = 0; //右序列下标
        int tempIndex = 0; //temp的下标

        while (leftIndex < firstHalf.length && rightIndex < secondHalf.length) {
            if (firstHalf[leftIndex] < secondHalf[rightIndex])
                temp[tempIndex++] = firstHalf[leftIndex++];
            else
                temp[tempIndex++] = secondHalf[rightIndex++];
        }
        while (leftIndex < firstHalf.length)
            temp[tempIndex++] = firstHalf[leftIndex++];
        while (rightIndex < secondHalf.length)
            temp[tempIndex++] = secondHalf[rightIndex++];
        return temp;
    }
}
