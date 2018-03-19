package com.algorithm.list.sort;

/**
 * 简单选择排序和二元选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] str = {4, 5, 1, 6, 2, 7, 3, 8};
        selectSort(str);
        Utils.print(str);
        int[] num = {3,1,5,2,6,7,9,8,4};
        twoSelectSort(num);
        Utils.print(num);
    }
    public static void selectSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int temp = list[i];
            int position = i; //最小值的下标
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < temp) {
                    temp = list[j];
                    position = j;
                }
            }
            list[position] = list[i];//交换位置
            list[i] = temp;
        }
    }

    /**
     * 二元选择排序
     * @param list
     */
    public static void twoSelectSort(int list[]) {
        int min, max, temp;
        for (int i = 1; i <= list.length / 2; i++) {
            // 做不超过n/2趟选择排序
            min = i;
            max = i; //分别记录最大和最小关键字记录位置
            for (int j = i + 1; j <= list.length - i; j++) {
                if (list[j] > list[max]) {
                    max = j;
                    continue;
                }
                if (list[j] < list[min]) {
                    min = j;
                }
            }
            //该交换操作还可分情况讨论以提高效率
            temp = list[i - 1];
            list[i - 1] = list[min];
            list[min] = temp;
            temp = list[list.length - i];
            list[list.length - i] = list[max];
            list[max] = temp;
        }
    }
}
