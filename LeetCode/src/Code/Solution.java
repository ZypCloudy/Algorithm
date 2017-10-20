package Code;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    //8. String to Integer (atoi)
    public int myAtoi(String str) {
        //这里要小心，需要判断有效性
        if(str==null || str.length() == 0) {
            return 0;
        }
        int nlen = str.length();
        double sum = 0;
        int sign = 1;
        int j = 0;
        //剔除空格
        while(str.charAt(j) == ' ')
            j++;
        //判断正数和负数
        if(str.charAt(j) == '+') {
            sign = 1;
            j++;
        }else if(str.charAt(j) == '-') {
            sign = -1;
            j++;
        }
        for(int i=j;i<nlen;i++) {
            char current = str.charAt(i);
            if(current >= '0' && current <= '9') {
                sum = sum*10 + (int)(current - '0');
            }
            else {
                break;//碰到非数字，退出转换
            }
        }
        sum = sum * sign;
        //这里要小心，需要判断范围
        if (sum > Integer.MAX_VALUE) {
            sum = Integer.MAX_VALUE;
        } else if (sum < Integer.MIN_VALUE) {
            sum = Integer.MIN_VALUE;
        }
        return (int)sum;
    }
//        Map map = new HashMap(){{
//            put('I',1);
//            put('V',5);
//            put('X',10);
//            put('L',50);
//            put('C',100);
//            put('D',500);
//            put('M',1000);
//        }};

    //13. Roman to Integer
    public int romanToInt(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    if (i == s.length() - 1) {
                        count++;
                        break;
                    }
                    if (s.charAt(i + 1) == 'V'||s.charAt(i + 1) == 'X') {
                        count--;
                        break;
                    } else {
                        count++;
                        break;
                    }
                case 'V':
                    count += 5;
                    break;
                case 'X':
                    if (i == s.length() - 1) {
                        count += 10;
                        break;
                    }
                    if (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C') {
                        count -= 10;
                        break;
                    } else {
                        count += 10;
                        break;
                    }
                case 'L':
                    count += 50;
                    break;
                case 'C':
                    if (i == s.length() - 1) {
                        count += 100;
                        break;
                    }
                    if (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M') {
                        count -= 100;
                        break;
                    } else {
                        count += 100;
                        break;
                    }
                case 'D':
                    count += 500;
                    break;
                case 'M':
                    count += 1000;
                    break;
            }
        }
        return count;
    }
}