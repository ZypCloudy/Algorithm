package com.algorithm.list.sort;

/**
 * 希尔排序
 */
public class SheelSort {
    public static void main(String[] args) {
        int[] str = {4, 5, 1, 6, 2, 7, 3, 8};
        sheelSort(str);
        Utils.print(str);
    }

    public static void sheelSort(int[] list) {
        int d = list.length;
        while (d != 0) {
            d = d / 2;
            for (int x = 0; x < d; x++) {//分的组数
                for (int i = x + d; i < list.length; i += d) {//组中的元素，从第二个数开始
                    int j = i - d;//j为有序序列最后一位的位数
                    int temp = list[i];//要插入的元素
                    for (; j >= 0 && temp < list[j]; j -= d) {//从后往前遍历。
                        list[j + d] = list[j];//向后移动d位
                    }
                    list[j + d] = temp;
                }
            }
        }
    }
}
