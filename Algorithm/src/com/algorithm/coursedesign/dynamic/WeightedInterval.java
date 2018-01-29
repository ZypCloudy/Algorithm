package com.algorithm.coursedesign.dynamic;

import java.util.Arrays;

/**
 * 带权重的区间调度
 */

public class WeightedInterval {

    public int[] interval(Work[] works, int[] position) {
        //根据结束时间排序
        Arrays.sort(works);
        for (int i = 1; i <= works.length - 1; i++) {
            //进行比较如果能进行该工作，则记录下下一个工作的位置
            for (int j = i - 1; j > 0; j--) {
                if (works[j].getEnd() <= works[i].getStart()) {
                    position[i] = j;
                    break;
                }
            }
        }
        return position;
    }

    // 动态规划算法
    private int[][] solve(Work[] works, int[] position) {
        int[] optimal = new int[works.length];
        int[][] record = new int[works.length][2];
        optimal[0] = 0;
        for (int i = 1; i <= works.length - 1; i++) {
            //比较权值,如果去这两个工作的权值比前面的大,选择该工作
            if (optimal[position[i]] + works[i].getWeight() >= optimal[i - 1]) {
                //更新权值
                optimal[i] = optimal[position[i]] + works[i].getWeight();

                record[i][0] = 1;
                record[i][1] = position[i];
            } else {
                optimal[i] = optimal[i - 1];
                record[i][0] = 0;
                record[i][1] = i - 1;
            }
        }
        return record;
    }

    private void output(int size, int[][] result, Work[] works) {
        int i = size - 1;
        while (i > 0) {
            if (result[i][0] == 1) {
                System.out.print("工作" + i + " ");
                System.out.println(works[i]);
            }
            i = result[i][1];
        }
    }

    public static void main(String args[]) {
        Work[] works = {
                new Work(12, 13, 200),
                new Work(14, 15, 1600),
                new Work(11, 20, 2000),
                new Work(21, 30, 1600),
                new Work(22, 24, 1000),
                new Work(25, 28, 1000),
        };
        //位置,pos表示这个工作前面和最近并且相容的工作
        int[] position = new int[works.length];
        WeightedInterval weightedInterval = new WeightedInterval();
        position = weightedInterval.interval(works, position);
        int[][] result = weightedInterval.solve(works, position);
        weightedInterval.output(works.length, result, works);
    }
}
