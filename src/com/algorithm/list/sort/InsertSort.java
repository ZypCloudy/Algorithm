package com.algorithm.list.sort;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] str = {4, 5, 1, 6, 2, 7, 3, 8};
        insertSort(str);
        Utils.print(str);
    }

    public static void insertSort(int[] list) {
        int insertNum;//要插入的数
        for (int i = 1; i < list.length; i++) {//插入的次数
            insertNum = list[i];//要插入的数
            int j = i - 1;//已经排序好的序列元素个数
            while (j >= 0 && list[j] > insertNum) {//序列从后到前循环，将大于insertNum的数向后移动一格
                list[j + 1] = list[j];//元素移动一格
                j--;
            }
            list[j + 1] = insertNum;//将需要插入的数放在要插入的位置。
        }
    }
}
