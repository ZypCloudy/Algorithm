package com.algorithm.list.sort;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] str = {4, 5, 1, 6, 2, 7, 3, 8};
        quickSort(str, 0, str.length - 1);
        Utils.print(str);
    }

    public static void quickSort(int[] numbers, int left, int right) {
        if (left < right) {
            int base = numbers[left]; // 选定的基准值（第一个数值作为基准值）
            int temp; // 记录临时中间值
            int i = left, j = right;
            do {
                while ((numbers[i] < base) && (i < right))
                    i++;
                while ((numbers[j] > base) && (j > left))
                    j--;
                if (i <= j) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (left < j)
                quickSort(numbers, left, j);
            if (right > i)
                quickSort(numbers, i, right);
        }
    }
}
