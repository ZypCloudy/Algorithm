package com.algorithm.coursedesign.traverse;

public class NineTable {
    private static int[][] num = new int[3][3];
    private static int[] used = new int[10];

    public static void search(int n) {
        int i;
        if (n == 9)
            testout();
        else {
            for (i = 1; i <= 9; i++) {
                if (used[i] == 0) {
                    num[n / 3][n % 3] = i;
                    used[i] = 1;//表示该数已经被用过，不能再一次使用
                    search(n + 1);
                    used[i] = 0; //回溯时使used[i]恢复原值
                }
            }
        }
    }

    public static void testout() {
        int i, flag = 1;
        for (i = 0; i < 3; i++) {
            if (num[i][0] + num[i][1] + num[i][2] != 15 || num[0][i] + num[1][i] + num[2][i] != 15) {
                flag = 0;
                break;
            }
        }
        if (flag == 1) {
            if (num[0][0] + num[1][1] + num[2][2] != 15 || num[0][2] + num[1][1] + num[2][0] != 15)
                flag = 0;
        }
        if (flag == 1)
            output();
    }

    public static void output() {
        int i, j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (j <= 1) {
                    System.out.print(num[i][j]);
                }
                if (j == 2) {
                    System.out.print(num[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        search(0);
    }
}
