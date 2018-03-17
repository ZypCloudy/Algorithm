package com.algorithm.coursedesign.dynamic;

import java.util.Arrays;

/**
 * 工作数最多的区间调度
 */
public class Interval {
    /**
     * 目标：工作数量最多
     * @param works
     * @return
     */
    public static int interval(Work[] works) {
        Arrays.sort(works);
        int count = 0;
        //当前工作的结束时间
        int t = 0;
        for (int i = 0; i < works.length; i++) {
            if (t < works[i].getStart()) {
                System.out.println(works[i]);
                count++;
                t = works[i].getEnd();
            }
        }
        return count;
    }

    public static void main(String args[]) {
        Work[] works = {
                new Work(12, 13, 2),
                new Work(11, 20, 20),
                new Work(14, 15, 5)
        };
        interval(works);
    }
}