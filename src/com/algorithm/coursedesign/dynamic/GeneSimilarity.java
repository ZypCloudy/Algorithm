package com.algorithm.coursedesign.dynamic;

/**
 * 基因相似度
 */
public class GeneSimilarity {
    /**
     * 获取字符对应的数字
     *
     * @param ch
     * @return
     */
    public int getCharNum(char ch) {
        if (ch == 'A') {
            return 0;
        } else if (ch == 'C') {
            return 1;
        } else if (ch == 'G') {
            return 2;
        } else if (ch == 'T') {
            return 3;
        } else {
            return 4;
        }
    }

    /**
     * 返回数组中
     *
     * @param arr
     * @return
     */
    public int max(int[] arr) {
        int temp = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (temp < arr[i]) {
                temp = arr[i];
            }
        }
        return temp;
    }

    /**
     * 求两个基因的相似度
     *
     * @param weights
     * @param gene1
     * @param gene2
     * @param m
     * @param n
     * @return
     */
    public int similarity(int[][] weights, String gene1, String gene2, int m, int n) {
        if (m < 0) {
            int similarity = 0;
            for (int i = 0; i <= n; i++) {
                similarity += weights[4][getCharNum(gene2.charAt(i))];
            }
            return similarity;
        } else if (n < 0) {
            int similarity = 0;
            for (int j = 0; j <= m; j++) {
                similarity += weights[getCharNum(gene1.charAt(m))][4];
            }
            return similarity;
        } else {
            int[] arr = {similarity(weights, gene1, gene2, m - 1, n - 1)
                    + weights[getCharNum(gene1.charAt(m))]
                    [getCharNum(gene2.charAt(n))],

                    similarity(weights, gene1, gene2, m - 1, n)
                            + weights[getCharNum(gene1.charAt(m))][4],

                    similarity(weights, gene1, gene2, m, n - 1)
                            + weights[4][getCharNum(gene2.charAt(n))]
            };
            return max(arr);
        }
    }

    public static void main(String[] args) {
        GeneSimilarity GS = new GeneSimilarity();

        int[][] weights = {
                {5, -1, -2, -1, -3},
                {-1, 5, -3, -2, -4},
                {-2, -3, 5, -2, -2},
                {-1, -2, -2, 5, -1},
                {-3, -4, -2, -1, Integer.MIN_VALUE}};
        String gene1 = "AGTGATG";
        String gene2 = "GTTAG";
        System.out.println(GS.similarity(weights, gene1, gene2, 6, 4));
    }
}
