package com.algorithm.coursedesign.recursion;

import java.util.Scanner;

/**
 * 二项式公式计算
 */
public class Binomial {
    public static void main(String[] args) {
        int[] v = input();
        int k = v[1];
        int n = v[0];
        long startRecursion = System.nanoTime();
        int result = recursion(n, k);
        long endRecursion = System.nanoTime();
        System.out.println("递归实现最后结果为:" + result + "耗时:" + (endRecursion - startRecursion));

        long startMemo = System.nanoTime();
        int memory = memo(n, k);
        long endMemo = System.nanoTime();
        System.out.println("备忘录实现最后结果为:" + memory + "耗时:" + (endMemo - startMemo));

        long start = System.nanoTime();
        int iteration = iteration(n, k);
        long end = System.nanoTime();
        System.out.println("迭代实现最后结果为:" + iteration + "耗时:" + (end - start));
    }

    /**
     * 递归实现二项式公式
     *
     * @param n
     * @param k
     * @return
     */
    public static int recursion(int n, int k) {
        //当k与n相等或者k=0时取1
        if (k == n || k == 0)
            return 1;
        else {
            return recursion(n - 1, k - 1) + recursion(n - 1, k);  //直接递归：用自身的编程
        }
    }

    public static int[][] memory = new int[100][100];

    /**
     * 备忘录方法实现二项式公式
     *
     * @param k
     * @param n
     * @return
     */
    public static int memo(int n, int k) {
        int temp;
        if (k == 0 || k == n) {
            temp = 1;
        } else if (memory[n][k] != 0) {//判断是否已经运算过。 
            temp = memory[n][k];
        } else {
            temp = memo(n - 1, k - 1) + memo(n - 1, k);
        }
        memory[n][k] = temp;
        return memory[n][k];
    }

    /**
     * 迭代实现二项式公式
     *
     * @param n
     * @param k
     * @return
     */
    public static int iteration(int n, int k) {
        int num[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            num[i] = 1;
            //k=0,n=k的情况
            for (int j = i - 1; j > 0; j--) {
                //在非边界的情况下，结果等于上一行同列数值+上一行同列前一个数值
                num[j] = num[j] + num[j - 1];
            }
        }
        return num[k];
    }

    public static int[] input() {
        int[] num = new int[2];
        System.out.print("请输入n：");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.print("请输入k：");
        int k = input.nextInt();
        if (k <= n) {
            num[0] = n;
            num[1] = k;
        } else {
            System.out.print("请重新输入：");
            input();
        }
        return num;
    }
}
