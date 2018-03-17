package com.algorithm.exercise;

import java.util.ArrayList;

/**
 * 背包问题-备忘录方法
 */

public class knapsack_memo {
    static int[] w = {3, 2, 1, 4, 5};
    static int[] v = {25, 20, 15, 40, 50};
    static int W = 6;
    static int[][] cache;
    static ArrayList result = new ArrayList();
    public static void main(String[] args) {
        cache = new int[w.length + 1][W + 1];
        for (int i = 0; i <= w.length; i++) {
            for (int j = 0; j <= W; j++) {
                cache[i][j] = -1;
            }
        }
        System.out.println("最大价值:" + knapsack(5, 6));
        traceback(5, 6);
        System.out.println("构成最大价值的物品编号:");
        for (Object i : result) {
            System.out.println(i);
        }
    }
    public static void traceback(int i, int j) {
        if (i > 0 && j > 0) {
            if (j >= w[i - 1]) {
                if (knapsack(i, j) == v[i - 1] + knapsack(i - 1, j - w[i - 1])) {
                    result.add(i - 1);
                    traceback(i - 1, j - w[i - 1]);
                } else {
                    traceback(i - 1, j);
                }
            } else {
                traceback(i - 1, j);
            }
        }
    }
    static public int knapsack(int i, int j) {
        if (i == 0 || j == 0) {
            return 0;
        }
        if (cache[i][j] == -1) {
            if (j >= w[i - 1]) {
                cache[i][j] = Math.max(v[i - 1] + knapsack(i - 1, j - w[i - 1]), knapsack(i - 1, j));
            } else {
                cache[i][j] = knapsack(i - 1, j);
            }
        }
        return cache[i][j];
    }
}
