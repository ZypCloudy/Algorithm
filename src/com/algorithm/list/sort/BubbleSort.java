package com.algorithm.list.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] str = {4, 5, 1, 6, 2, 7, 3, 8};
        bubbleSort(str);
        Utils.print(str);
    }
    public static void bubbleSort(int[] list) {
        int temp;
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length - i - 1; j++) {
                if (list[j] > list[j + 1]) {
                    temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }
}
