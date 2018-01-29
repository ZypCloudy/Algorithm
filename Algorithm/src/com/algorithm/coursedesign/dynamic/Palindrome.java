package com.algorithm.coursedesign.dynamic;

/**
 * 最长的回文子序列
 */
public class Palindrome {
    public int palindrome(String str, int[][] counts) {
        int len = str.length();
        int[][] res = new int[len][len];
        for (int i = 0; i < len; i++) {
            res[i][i] = 1;
            counts[i][i] = 1;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                int k = j + i;
                if (str.charAt(j) == str.charAt(k)) {
                    if (k - j == 1) {
                        res[j][k] = 2;
                    } else {
                        res[j][k] = res[j + 1][k - 1] + 2;
                    }
                    counts[j][k] = 1;
                } else if (res[j + 1][k] > res[j][k - 1]) {
                    res[j][k] = res[j + 1][k];
                    counts[j][k] = -1;
                } else {
                    res[j][k] = res[j][k - 1];
                    counts[j][k] = -2;
                }
            }

        }
        return res[0][len - 1];
    }

    public String traceback(String str, int[][] counts) {
        //回文字串前半部分记录结果
        String sRes = "";
        //记录回文字串后半部分结果
        String eRes = "";
        int sIndex = 0;
        int eIndex = counts.length - 1;
        while (sIndex <= eIndex) {
            if (str.charAt(sIndex) == str.charAt(eIndex)) {
                if (sIndex != eIndex) {
                    sRes += str.charAt(sIndex);
                }
                eRes = str.charAt(eIndex) + eRes;
                sIndex++;
                eIndex--;
            } else if (counts[sIndex][eIndex] == -1) {
                sIndex++;
            } else {
                eIndex--;
            }
        }
        return sRes + eRes;
    }

    public static void main(String[] args) {
        Palindrome ps = new Palindrome();
        String str1 = "ACGTGTCAAAATCG";
        int[][] counts = new int[str1.length()][str1.length()];
        System.out.println(ps.palindrome(str1, counts));
        System.out.println(ps.traceback(str1, counts));
    }
}